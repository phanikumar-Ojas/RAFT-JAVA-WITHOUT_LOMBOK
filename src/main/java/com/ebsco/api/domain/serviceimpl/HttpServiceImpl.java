package com.ebsco.api.domain.serviceimpl;

import static com.ebsco.constants.EbescoConstants.EHOST_SEARCH_LINK;
import static com.ebsco.constants.EbescoConstants.PDF_FULL_TEXT;
import static com.ebsco.constants.EbescoConstants.WINDOW_LOCATION_REPLACE;
import static com.ebsco.data.validation.StringDataValidator.validateStringData;

import com.ebsco.api.domain.service.HttpReaderService;
import com.ebsco.api.domain.service.HttpService;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HttpServiceImpl implements HttpService {

  @Autowired
  HttpReaderService httpReaderService;

  @Override
  public Boolean isEhostFtLinkToBeReturned(String ehostFtUrl, String pmId) {

    boolean isAvailable = false;
    validateStringData(ehostFtUrl);
    try {
      String dataFromUrl = getDataFromUrl(ehostFtUrl);
      validateStringData(dataFromUrl);
      int indexOf = dataFromUrl.indexOf(WINDOW_LOCATION_REPLACE);
      if (indexOf != -1) {
        String pdfFullTextDetails = dataFromUrl.substring(indexOf, dataFromUrl.length());
        validateStringData(pdfFullTextDetails);
        int subIndex = pdfFullTextDetails.indexOf(WINDOW_LOCATION_REPLACE);
        if (subIndex != -1) {
          int indexOfBracket = pdfFullTextDetails.indexOf("')");
          if (indexOfBracket != -1) {
            pdfFullTextDetails = pdfFullTextDetails
              .substring(WINDOW_LOCATION_REPLACE.length() + 1, indexOfBracket);
            pdfFullTextDetails =
              EHOST_SEARCH_LINK + pdfFullTextDetails.replace("'", "") + "#AN=" + pmId + "&db=mdc";

            String pdfFullTextData = getDataFromUrl(pdfFullTextDetails);
            validateStringData(pdfFullTextData);
            isAvailable = pdfFullTextData.contains(PDF_FULL_TEXT);


          }
        }

      }


    } catch (Exception exception) {
      log.error(exception.getMessage());

    }
    return isAvailable;
  }

  @Override
  public String sendingPostRequest(String url) throws Exception {

    validateStringData(url);
    URL obj = new URL(url);
    HttpURLConnection con = (HttpURLConnection) obj.openConnection();

    // Setting basic post request
    con.setRequestMethod("POST");
    con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
    con.setRequestProperty("Content-Type", "application/json");

    // Send post request
    con.setDoOutput(true);
    DataOutputStream wr = new DataOutputStream(con.getOutputStream());
    wr.flush();
    wr.close();

    int responseCode = con.getResponseCode();
    System.out.println("nSending 'POST' request to URL : " + url);
    System.out.println("Response Code : " + responseCode);

    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String output;
    StringBuffer response = new StringBuffer();

    while ((output = in.readLine()) != null) {
      response.append(output);
    }
    in.close();

    // printing result from response
    System.out.println(response.toString());
    return response.toString();
  }

  @Override
  public String getResponse(String URL) throws IOException {
    validateStringData(URL);
    try {
      String response_string = null;
      StringBuilder response = new StringBuilder();
      URL url = new URL(URL);
      HttpURLConnection httpconn = (HttpURLConnection) url.openConnection();

      if (httpconn.getResponseCode() == HttpURLConnection.HTTP_OK) {
        BufferedReader input = new BufferedReader(new InputStreamReader(httpconn.getInputStream()));
        String strLine = null;
        while ((strLine = input.readLine()) != null) {
          response.append(strLine);
        }
        input.close();
        response_string = response.toString();
      }

      httpconn.disconnect();

      return response_string;
    } catch (Exception e) {
      throw new IOException();
    }
  }

  @Override
  public Pair<Boolean, String> isFreeArticle(String url) {
    validateStringData(url);
    try {
      String data = getDataFromUrl(url);
      validateStringData(data);
      boolean free_pmc_article = data.contains("Free PMC article");

      String fullTextUrl = getFullTextUrl(data);

      return Pair.of(free_pmc_article, fullTextUrl);

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public String getDataFromUrl(String url) {
    validateStringData(url);
    try {
      return Jsoup.connect(url).get().toString();

    } catch (Exception e) {
      log.error(e.getMessage());
      return null;
    }
  }

  @Override
  public String getFullTextUrl(String url) {
    validateStringData(url);
    String fullTextUrl = null;
    try {
      Document document = Jsoup.parse(url);

      Elements elementsByClass = document.getElementsByClass("full-text-links-list");
      if (Objects.nonNull(elementsByClass) && !elementsByClass.isEmpty()) {
        Element element = elementsByClass.get(0);
        Element childElement = element.children().get(0);
        boolean href = childElement.hasAttr("href");
        if (href) {
          fullTextUrl = childElement.attr("href");
        }
      }
    } catch (Exception exception) {
      log.error(exception.getMessage());
      return null;

    }
    return fullTextUrl;
  }
}

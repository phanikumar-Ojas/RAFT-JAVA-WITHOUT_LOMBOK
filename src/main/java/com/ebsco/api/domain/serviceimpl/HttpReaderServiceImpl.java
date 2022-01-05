package com.ebsco.api.domain.serviceimpl;

import static com.ebsco.constants.EbescoConstants.EHOST_LINK_URL_START;
import static com.ebsco.constants.EbescoConstants.NCBI;
import static com.ebsco.constants.EbescoConstants.OPEN_FREE_FULL_TEXT;
import static com.ebsco.constants.EbescoConstants.PMID_FREE_ARTICLE_INSTRUCTIONS_PDF_DOWNLOAD;
import static com.ebsco.constants.EbescoConstants.REQUEST_FULL_TEXT;

import com.ebsco.api.domain.service.HttpReaderService;
import com.ebsco.api.domain.service.HttpService;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.validation.StringDataValidator;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class HttpReaderServiceImpl implements HttpReaderService {
  private static final Logger log= LoggerFactory.getLogger(HttpReaderServiceImpl.class);


  @Autowired
  private HttpService httpService;

  private static String getEhostFtLink(String pmId) {
    return EHOST_LINK_URL_START + pmId + "&site=ehost-live";

  }

  @Override
  @Cacheable("/processHtml")
  public FullTextRequest processHtmlData(String fileData, int requestId,
    Boolean isFreeRequest, String fullTextUrl) {
    Document htmlFile = null;
    String title = null;
    StringBuilder citaion = new StringBuilder();
    String pmId = null;
    String pwcId = null;
    String pmcId = null;
    String journalTitle = null;
    String nesId = null;
    try {
      htmlFile = Jsoup.parse(fileData);
      if (htmlFile != null) {
        title = htmlFile.title();
        nesId = new SimpleDateFormat("yyyyMMdd").format(new Date()) + (requestId + 1);

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        Elements elementsByAttributeValue = htmlFile
          .getElementsByAttributeValue("name", "citation_journal_title");
        if (elementsByAttributeValue != null && !elementsByAttributeValue.isEmpty()) {
          journalTitle = elementsByAttributeValue
            .attr("content");
        }
        Elements citElements = htmlFile.getElementsByClass("cit");
        String citeText = "";
        if (citElements != null && !citElements.isEmpty()) {
          citeText = citElements.get(0).text();
        }
        // journal period cit citation-doi full-view-identifiers
        Elements journalELements = htmlFile.getElementsByClass("journal");
        if (journalELements != null && !journalELements.isEmpty()) {
          citaion.append(journalELements.get(0).text());
        }
        Elements periodElements = htmlFile.getElementsByClass("period");
        if (periodElements != null && !periodElements.isEmpty()) {
          citaion.append(periodElements.get(0).text());
        }
        citaion.append(citeText);
        Elements elementsByClassCitationDoi = htmlFile.getElementsByClass("citation-doi");
        if (elementsByClassCitationDoi != null && !elementsByClassCitationDoi.isEmpty()) {
          citaion.append(elementsByClassCitationDoi.get(0).text());
        }
        Elements elementsByClass = htmlFile.getElementsByClass("identifier pmc");
        if (elementsByClass != null && !elementsByClass.isEmpty()) {
          pmcId = elementsByClass.get(0).text().replace(":", "").replace("PMCID", "");
        }

        System.out.println("ciation" + citaion);

        Element data = htmlFile.getElementById("full-view-identifiers");

        if (Objects.nonNull(data)) {
          Elements aTagElements = data.getElementsByTag("a");
          if (aTagElements != null && !aTagElements.isEmpty()) {
            Element element = aTagElements.get(0);
            if (element != null) {
              pmId = element.text();
            }
          }
        }
      }
// full-text-links-list
      String ehostFtLink = getEhostFtLink(pmId);
      Boolean toBeReturned = httpService.isEhostFtLinkToBeReturned(ehostFtLink, pmId);


      String pubMedFreeFtUrl = null;
      String instructions = "";
      String ftRetrievedFrom = "";
      String status = null;
      if (isFreeRequest) {
        if (pmcId != null) {
          pubMedFreeFtUrl = getPubMedFreeFtUrl(pmcId);
        }
        instructions = PMID_FREE_ARTICLE_INSTRUCTIONS_PDF_DOWNLOAD;
        ftRetrievedFrom = "PubMed";
      }
      if (toBeReturned) {
        instructions = PMID_FREE_ARTICLE_INSTRUCTIONS_PDF_DOWNLOAD;

        ftRetrievedFrom = "PDF Viewer";
      }
      if (fullTextUrl != null) {
        instructions = PMID_FREE_ARTICLE_INSTRUCTIONS_PDF_DOWNLOAD;

        ftRetrievedFrom = "Free Downloads";
      }

      if (pubMedFreeFtUrl == null || !toBeReturned || fullTextUrl != null) {
        status = OPEN_FREE_FULL_TEXT;
      } else {
        status = REQUEST_FULL_TEXT;
      }

      return FullTextRequest.builder().title(title).citation(citaion.toString())
        .pmId(pmId != null ? Integer.valueOf(pmId) : null)
        .creationDate(Instant.now()).priority("Normal").reOpened(false).isSlamRecord(false)
        .journalTitle(journalTitle).isRequested(true)
        .pubMedFTURL(
          pmcId != null && !pmcId.isEmpty() && pubMedFreeFtUrl != null ? pubMedFreeFtUrl : "")
        .ehostFTLink(toBeReturned ? ehostFtLink : null).requestID(requestId + 1).nesId(nesId)
        .status(status)
        .instructions(instructions)
        .ftRetrievedFrom(ftRetrievedFrom)
        .fullTextURL(fullTextUrl)
        .build();

    } catch (Exception e) {
      e.printStackTrace();
      return null;

    }
  }

  @Override
  @Cacheable("/pubMedUrl")
  public String getPubMedFreeFtUrl(String pmcId) {
    String pubMedUrl = NCBI + pmcId.trim();
    String dataFromUrl = httpService.getDataFromUrl(pubMedUrl);
    StringDataValidator.validateStringData(dataFromUrl);
    assert dataFromUrl != null;
    Document parse = Jsoup.parse(dataFromUrl);
    Elements elementsByClass = parse.getElementsByClass("format-menu");
    Element element = elementsByClass.get(0);
    List<Node> nodes = element.childNodes();
    Node ul = nodes.stream().filter(n -> n.nodeName().equalsIgnoreCase("ul")).findFirst().get();
    String nodeName = ul.nodeName();
    List<Node> nodesList = ul.childNodes();
    Node node1 = nodesList.get(7);
    String href = node1.childNode(0).attr("href");

    return NCBI + href.replace("/pmc/articles/", "");

  }

}

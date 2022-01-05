package com.ebsco.api.domain.service;

import java.io.IOException;
import org.apache.commons.lang3.tuple.Pair;

public interface HttpService {

  Boolean isEhostFtLinkToBeReturned(String ehostFtUrl, String pmId);

  String sendingPostRequest(String url) throws Exception;

  String getResponse(String URL) throws IOException;

  Pair<Boolean,String> isFreeArticle(String url);

  String getDataFromUrl(String url);

  String getFullTextUrl(String url);

}

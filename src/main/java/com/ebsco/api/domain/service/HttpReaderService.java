package com.ebsco.api.domain.service;

import com.ebsco.data.entity.FullTextRequest;

public interface HttpReaderService {

  FullTextRequest processHtmlData(String fileData, int requestId,
    Boolean isFreeRequest,String fullTextRequest);

  String getPubMedFreeFtUrl(String pmcId);

}

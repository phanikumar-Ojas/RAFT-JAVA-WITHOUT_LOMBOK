package com.ebsco.api.domain.service;

import com.ebsco.data.entity.FullTextRequest;
import java.util.List;

public interface FullTextUtilService {

  List<Integer> processIds(String ids);

  FullTextRequest getFullTextRequestWithModifiedStatus(FullTextRequest fullTextRequest);

  String getStatusOfFullTextRequest(String status,
    Boolean isRequested, Boolean isReviewd);

  String getModifiedStatus(String status, Boolean isRequested, Boolean isReviewd);

}

package com.ebsco.api.domain.serviceimpl;

import static com.ebsco.constants.EbescoConstants.CANCELED_REQUEST;
import static com.ebsco.constants.EbescoConstants.DATA_COMMASEPERATOR;
import static com.ebsco.constants.EbescoConstants.IN_PROGRESS;
import static com.ebsco.constants.EbescoConstants.NOT_REQUIRED;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.api.domain.service.FullTextUtilService;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class FullTextUtilServiceImpl implements FullTextUtilService {

  @Override
  @Cacheable("idsRequests")
  public List<Integer> processIds(String ids) {
    checkNotNull(ids, "pmIds required but found null");
    checkArgument(StringUtils.isNotBlank(ids), "pmIds required but fond blank");
    checkArgument(StringUtils.isNotEmpty(ids), "pmIds required but fond empty");

    String[] strings = StringUtils.split(ids, DATA_COMMASEPERATOR);

    if (Objects.nonNull(strings) && strings.length > 0) {
      return Stream.of(strings).map(Integer::parseInt).collect(Collectors.toList());
    } else {
      return Collections.singletonList(Integer.parseInt(ids));
    }
  }

  @Override
  @Cacheable("statusOfFullText")
  public FullTextRequest getFullTextRequestWithModifiedStatus(
    FullTextRequest fullTextRequest) {
    checkNotNull(fullTextRequest, "fullTextRequest required but found null");
    String status = getStatusOfFullTextRequest(fullTextRequest.getStatus(),
      fullTextRequest.getIsRequested(),
      fullTextRequest.getIsReviewed());
    fullTextRequest.setStatus(status);

    return fullTextRequest;
  }

  @Override
  public String getStatusOfFullTextRequest(String status, Boolean isRequested,
    Boolean isReviewd) {
    return getModifiedStatus(status, isRequested, isReviewd);
  }

  @Override
  public String getModifiedStatus(String status, Boolean isRequested, Boolean isReviewd) {
    if (Objects.isNull(status) || StringUtils.isEmpty(status) || StringUtils.isBlank(status)) {
      if (isRequested != null) {
        if (!isRequested) {
          return CANCELED_REQUEST;
        } else if (Objects.nonNull(isReviewd) && !isReviewd) {
          return IN_PROGRESS;
        }
      }
    } else {
      if (isRequested != null && isRequested.equals(true) && Objects.nonNull(isReviewd)
        && isReviewd
        .equals(true)) {
        return status;
      } else if (status.equalsIgnoreCase(IN_PROGRESS) || status.equalsIgnoreCase(NOT_REQUIRED)) {
        return status;
      }
    }

    return null;
  }
}

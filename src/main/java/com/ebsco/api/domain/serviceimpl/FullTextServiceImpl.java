package com.ebsco.api.domain.serviceimpl;

import static com.ebsco.constants.EbescoConstants.EBESCOHOSTPREFIX;
import static com.ebsco.constants.EbescoConstants.EBESCOHOSTSUFFIX;
import static com.ebsco.constants.EbescoConstants.PUBMED_FT_URL;
import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.repository.FullTextRepository;
import com.ebsco.api.domain.service.FullTextService;
import com.ebsco.api.domain.service.FullTextUtilService;
import com.ebsco.api.domain.service.HttpService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.FullTextRequestDtoList;
import com.ebsco.data.dto.FullTextRsponseDto;
import com.ebsco.data.template.FullTextSearchTemplate;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.exception.FullTextRequestDataNotFoundException;
import com.ebsco.api.domain.repository.UserRepository;
import com.ebsco.api.domain.service.HttpReaderService;
import com.ebsco.transformer.FullTextTransformer;
import com.ebsco.util.PaginationUtils;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class FullTextServiceImpl implements FullTextService {

  @Autowired
  FullTextRepository reposistory;

  @Autowired
  UserRepository userRepostiry;

  @Autowired
  FullTextUtilService fullTextUtilService;

  @Autowired
  HttpService httpService;

  @Autowired
  HttpReaderService httpReaderService;

  @Override
  @Cacheable("findByPmId")
  public List<FullTextRequestDto> findByPmId(List<Integer> pmIdsList, String userName) {

    List<FullTextRequestDto> fullTextRequestDtos = Lists.newArrayList();
    if (Objects.nonNull(pmIdsList) && !pmIdsList.isEmpty()) {
      for (Integer pmId : pmIdsList) {
        validateArguments(pmId, userName);
        FullTextRequest fullTextRequest = null;
        int pmIdCount = reposistory.getPmIdCount(pmId);
        FullTextRequestDto fullTextRequestDto = null;
        if (pmIdCount > 0) {
          fullTextRequest = reposistory.findByPmId(pmId);

          fullTextRequestDto = FullTextTransformer
            .fromFullTextRequest(fullTextRequest);
          fullTextRequestDto.setIsExist(true);
          String statusOfFullTextRequest = fullTextUtilService.getStatusOfFullTextRequest(
            fullTextRequestDto.getStatus(),
            fullTextRequestDto.getIsRequested(), fullTextRequestDto.getIsReviewed());
          fullTextRequestDto.setStatus(statusOfFullTextRequest);
        } else {
          try {
            String sendingPostRequest = null;
            int requestId = reposistory.findMaxRequestId();

            System.out.println("PubMed");

            sendingPostRequest = httpService.getResponse(PUBMED_FT_URL + pmId + "/");

            if (sendingPostRequest != null && !sendingPostRequest.isEmpty()) {

              Pair<Boolean, String> isFreeRequest = httpService
                .isFreeArticle(PUBMED_FT_URL + pmId + "/");
              FullTextRequest fRequest = httpReaderService
                .processHtmlData(sendingPostRequest, requestId, isFreeRequest.getLeft(),
                  isFreeRequest.getRight());
              if (Objects.nonNull(fRequest)) {
                fullTextRequestDto = FullTextTransformer.fromFullTextRequest(fRequest);
              }

            } else {
              System.out.println("ebesco");

              sendingPostRequest = httpService
                .getResponse(EBESCOHOSTPREFIX + pmId + EBESCOHOSTSUFFIX);
              Pair<Boolean, String> isFreeRequest = httpService
                .isFreeArticle(PUBMED_FT_URL + pmId + "/");

              FullTextRequest fRequest = httpReaderService
                .processHtmlData(sendingPostRequest, requestId, isFreeRequest.getLeft(),
                  isFreeRequest.getRight());
              if (Objects.nonNull(fRequest)) {
                fullTextRequestDto = FullTextTransformer.fromFullTextRequest(fRequest);

              }

            }

          } catch (Exception e) {
            return null;
          }
        }
        fullTextRequestDtos.add(fullTextRequestDto);
      }
    }

    return fullTextRequestDtos;
  }


  @Override
  public List<FullTextRequest> findAll() {
    return reposistory.findAll();
  }

  @Override
  @Cacheable("searchTemplateCache")
  public Response searchForRequests(FullTextSearchTemplate searchTemplate) {
    List<FullTextRequest> allRequestsBasedOnSearchTemplate = reposistory
      .getAllRequestsBasedOnSearchTemplate(searchTemplate.getStatus(),
        searchTemplate.getPriority(), searchTemplate.getPmId(), searchTemplate.getCostCenter(),
        searchTemplate.getPageNumber(), searchTemplate.getPageSize(),
        searchTemplate.getFrom(),
        searchTemplate.getTo());

    if (!allRequestsBasedOnSearchTemplate.isEmpty()) {
      Integer totalPages = 1;
      int totalCount = allRequestsBasedOnSearchTemplate.size();
      if (!(allRequestsBasedOnSearchTemplate.size() < searchTemplate.getPageSize())) {
        totalCount = reposistory
          .getCountBasedOnSearchTemplate(searchTemplate.getStatus(),
            searchTemplate.getPriority(), searchTemplate.getPmId(), searchTemplate.getCostCenter(),
            searchTemplate.getFrom(),
            searchTemplate.getTo());
        totalPages = PaginationUtils.getTotalPages(totalCount, searchTemplate.getPageSize());
      }
      return Response.builder().result(allRequestsBasedOnSearchTemplate)
        .status(ExceptionMessage.OK).totalPages(totalPages).totalRecords(totalCount).build();
    }
    return Response.builder().status(ExceptionMessage.Not_Found)
      .res("fullText details not found with the given searchTemplate").build();
  }

  @Override
  public FullTextRequest save(FullTextRequest fullTextRequest) {
    checkNotNull(fullTextRequest, "fullTextRequest required but found null");

    return reposistory.save(fullTextRequest);
  }

  @Override
  public List<FullTextRequest> getLatest10Records() {
    List<FullTextRequest> lastest10Records;
    try {
      lastest10Records = reposistory.findLastest10Records();
      if (Objects.nonNull(lastest10Records) && !lastest10Records.isEmpty()) {

        lastest10Records = lastest10Records.stream()
          .map(fullTextUtilService::getFullTextRequestWithModifiedStatus)
          .collect(Collectors.toList());
      }
      return lastest10Records;
    } catch (Exception exception) {
      return null;
    }

  }

  @Override
  @Transactional
  public FullTextRequest getFullTextRequestById(Integer id, boolean isFetchable) {

    checkNotNull(id, "fullTextRequestId must required but found null");
    FullTextRequest fullTextRequestByRequestID = reposistory.getFullTextRequestByRequestID(id);

    if (!isFetchable) {
      log.debug("updating the fullTextRequest");
      int updatedCount = reposistory.updateFullTextRequestBasedOnId(id);
      log.debug("updated count:" + updatedCount);
      if (updatedCount == 1) {
        fullTextRequestByRequestID.setStatus(null);
        fullTextRequestByRequestID.setIsRequested(false);
        fullTextRequestByRequestID.setIsReviewed(false);
        fullTextRequestByRequestID.setReviewedBy(null);
        fullTextRequestByRequestID.setReviewedOn(null);
      }
    }
    return fullTextRequestByRequestID;
  }

  @Override
  @Transactional(rollbackOn = Exception.class)
  public FullTextRsponseDto saveFullTexts(
    FullTextRequestDtoList fullTextRequestDtoList) {

    if (Objects.nonNull(fullTextRequestDtoList) && !CollectionUtils
      .isEmpty(fullTextRequestDtoList.getFullTextRequestDtoList())) {
      return null;
    }

    List<FullTextRequestDto> fullTextRequestDtos = new ArrayList<>();
    for (FullTextRequestDto fullTextRequestDto : fullTextRequestDtoList
      .getFullTextRequestDtoList()) {
      FullTextRequest fullTextRequest = FullTextTransformer.toFullTextRequest(fullTextRequestDto);

      FullTextRequest savedFullTextRequest = save(fullTextRequest);
      fullTextRequestDtos.add(FullTextTransformer.fromFullTextRequest(savedFullTextRequest));

    }

    return FullTextRsponseDto.builder().fullTextRequestDtoList(fullTextRequestDtos).build();

  }

  public void validateArguments(Integer id, String userName) {
    if (Objects.isNull(id)) {
      throw new FullTextRequestDataNotFoundException("id must required but found null");
    }
    if (Objects.isNull(userName)) {
      throw new FullTextRequestDataNotFoundException("userName must required but found null");
    }
    if (StringUtils.isEmpty(userName)) {
      throw new FullTextRequestDataNotFoundException("userName must required but found empty");
    }
    if (StringUtils.isBlank(userName)) {
      throw new FullTextRequestDataNotFoundException("userName must required but found blank");
    }

  }
//
//  public String getStringFromInstant(Instant instant) {
//    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//    String format = formatter.format(Date.from(instant));
//    System.out.println(format);
//    return format;
//  }

}

package com.ebsco.api.domain.serviceimpl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.service.FullFillService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.template.FullFillSearchTemplate;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.api.domain.repository.FullFillRepository;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.transformer.FullTextTransformer;
import com.ebsco.util.PaginationUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
@Slf4j
public class FullFillServiceImpl implements FullFillService {

  @Autowired
  private FullFillRepository fullFillRepository;

  @Override
  public List<FullTextRequestDto> getGridData() {
    List<FullTextRequest> fullFillGridData = fullFillRepository.findFullFillGridData();
    if (Objects.nonNull(fullFillGridData) && !CollectionUtils.isEmpty(fullFillGridData)) {
      return fullFillGridData.stream().map(FullTextTransformer::fromFullTextRequest)
        .collect(Collectors.toList());
    }
    return null;

  }

  @Override
  @Cacheable("SearchingMechanism")
  public Response getFullFillRequestBasedOnSearchTemplate(
    FullFillSearchTemplate searchTemplate) {
    checkNotNull(searchTemplate, "searchTemplate Required butfound null");
    String status = searchTemplate.getStatus();
    String userName = searchTemplate.getUserName();
    String pmId = searchTemplate.getPmId();

    if (Objects.nonNull(status) && status.equalsIgnoreCase("All")) {
      status = null;
    }
    if (Objects.nonNull(userName) && userName.equalsIgnoreCase("AllUsers")) {
      userName = null;
    }

    if(Objects.isNull(pmId) || StringUtils.isBlank(pmId) || StringUtils.isEmpty(pmId)){
      pmId=null;
    }

    DtoValidationUtils
      .validatePageNumberAndPageSize(searchTemplate.getPageNumber(), searchTemplate.getPageSize());

    List<FullTextRequest> allRequestsBasedOnSearchTemplate;
    if (Objects.nonNull(searchTemplate.getPageSize()) && Objects
      .nonNull(searchTemplate.getPageNumber())) {
      allRequestsBasedOnSearchTemplate = fullFillRepository
        .searchBasedOnFullFillSearchTemplateWithPagination(status,
          searchTemplate.getPriority(), pmId,
          searchTemplate.getFtRetrievedFrom(),
          searchTemplate.getFrom(),
          searchTemplate.getTo(), userName, searchTemplate.getPageNumber(),
          searchTemplate.getPageSize());
      if (Objects.nonNull(allRequestsBasedOnSearchTemplate) && !CollectionUtils
        .isEmpty(allRequestsBasedOnSearchTemplate)) {

        Integer totalPages = 1;
        int totalCount = allRequestsBasedOnSearchTemplate.size();
        if (!(allRequestsBasedOnSearchTemplate.size() < searchTemplate.getPageSize())) {
          totalCount = fullFillRepository
            .getCountBasedOnFullFillSearchTemplate(searchTemplate.getStatus(),
              searchTemplate.getPriority(), pmId,
              searchTemplate.getFtRetrievedFrom(), searchTemplate.getFrom(), searchTemplate.getTo(),
              userName
            );
          totalPages = PaginationUtils.getTotalPages(totalCount, searchTemplate.getPageSize());
        }

        return Response.builder().totalPages(totalPages).totalRecords(totalCount)
          .result(allRequestsBasedOnSearchTemplate).status(
            ExceptionMessage.OK).build();
      }
    } else {
      allRequestsBasedOnSearchTemplate = fullFillRepository
        .searchBasedOnFullFillSearchTemplate(status,
          searchTemplate.getPriority(), pmId,
          searchTemplate.getFtRetrievedFrom(),
          searchTemplate.getFrom(),
          searchTemplate.getTo(), userName);

    }
    return Response.builder()
      .result(allRequestsBasedOnSearchTemplate).status(
        ExceptionMessage.OK).build();

  }
}


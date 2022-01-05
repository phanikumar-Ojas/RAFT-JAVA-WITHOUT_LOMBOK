package com.ebsco.api.domain.serviceimpl;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.repository.ReportsRepository;
import com.ebsco.api.domain.service.ReportsService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.template.ReportsSearchTemplate;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.transformer.FullTextTransformer;
import com.ebsco.util.PaginationUtils;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

@Service
public class ReportsServiceImpl implements ReportsService {

  @Autowired
  private ReportsRepository reportsRepository;

  @Override
  public List<FullTextRequestDto> getGridData() {
    List<FullTextRequest> reportsGridData = reportsRepository.findReportsGridData();
    if (Objects.nonNull(reportsGridData) && !CollectionUtils.isEmpty(reportsGridData)) {
      return reportsGridData.stream().map(FullTextTransformer::fromFullTextRequest)
        .collect(Collectors.toList());
    }
    return null;
  }

  @Override
  public Response getReportsRequestBasedOnSearchTemplate(
    ReportsSearchTemplate searchTemplate) {
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

    if (Objects.isNull(pmId) || StringUtils.isBlank(pmId) || StringUtils.isEmpty(pmId)) {
      pmId = null;
    }

    DtoValidationUtils
      .validatePageNumberAndPageSize(searchTemplate.getPageNumber(), searchTemplate.getPageSize());

    List<FullTextRequest> allRequestsBasedOnSearchTemplate;
    if (Objects.nonNull(searchTemplate.getPageSize()) && Objects
      .nonNull(searchTemplate.getPageNumber())) {
      allRequestsBasedOnSearchTemplate = reportsRepository
        .searchBasedOnReportsSearchTemplateWithPagination(status,
          searchTemplate.getPriority(), pmId,
          searchTemplate.getCostCenter(),
          searchTemplate.getFrom(),
          searchTemplate.getTo(), userName, searchTemplate.getPageNumber(),
          searchTemplate.getPageSize());
      if (Objects.nonNull(allRequestsBasedOnSearchTemplate) && !CollectionUtils
        .isEmpty(allRequestsBasedOnSearchTemplate)) {

        Integer totalPages = 1;
        int totalCount = allRequestsBasedOnSearchTemplate.size();
        if (!(allRequestsBasedOnSearchTemplate.size() < searchTemplate.getPageSize())) {
          totalCount = reportsRepository
            .getCountBasedOnPerportsSearchTemplate(searchTemplate.getStatus(),
              searchTemplate.getPriority(), pmId,
              searchTemplate.getCostCenter(), searchTemplate.getFrom(), searchTemplate.getTo(),
              userName
            );
          totalPages = PaginationUtils.getTotalPages(totalCount, searchTemplate.getPageSize());
        }

        return Response.builder().totalPages(totalPages).totalRecords(totalCount)
          .result(allRequestsBasedOnSearchTemplate).status(
            ExceptionMessage.OK).build();
      }
    } else {
      allRequestsBasedOnSearchTemplate = reportsRepository
        .searchBasedOnReportsSearchTemplate(status,
          searchTemplate.getPriority(), pmId,
          searchTemplate.getCostCenter(),
          searchTemplate.getFrom(),
          searchTemplate.getTo(), userName);

    }
    return Response.builder()
      .result(allRequestsBasedOnSearchTemplate).status(
        ExceptionMessage.OK).build();

  }

}


package com.ebsco.api.domain.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.service.FileDownloadService;
import com.ebsco.api.domain.service.FullFillService;
import com.ebsco.api.domain.service.ReportsService;
import com.ebsco.api.domain.serviceimpl.FileDownloadServiceImpl;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.GridDataDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.template.FullFillSearchTemplate;
import com.ebsco.data.template.ReportsSearchTemplate;
import com.ebsco.transformer.FullTextTransformer;
import io.swagger.annotations.Api;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/raft/report")
@Api(description = "This is a Reports Controller which is used to use the operations of Reports Page")
public class ReportsController {

  @Autowired
  ReportsService reportsService;

  private FileDownloadService fileDownloadService;


  @GetMapping("/gridData")
  public Response getGridData() {
    List<FullTextRequestDto> fullFillServiceGridData = reportsService.getGridData();
    return Response.builder().result(fullFillServiceGridData).status(ExceptionMessage.OK).build();
  }

  @PostMapping("/gridDataToFile")
  public Response getGridData(@Valid @RequestBody GridDataDto gridDataDto) {

    try {
      List<FullTextRequestDto> latest10Records = reportsService.getGridData();
      if (Objects.nonNull(latest10Records) && !CollectionUtils.isEmpty(latest10Records)) {

        if (gridDataDto.getIsFileDownload() != null) {
          if (!gridDataDto.getIsFileDownload()) {
            return Response.builder().result(latest10Records).httpStatus(HttpStatus.OK).build();
          } else {
            fileDownloadService = new FileDownloadServiceImpl(gridDataDto.getFileType());
            String fileData = fileDownloadService.createFile(latest10Records);

//          return Response.builder().status(ExceptionMessage.OK).encodedString(fileData).build();
            return Response.builder().encodedString(fileData).status(ExceptionMessage.OK).build();
          }

        }
        return Response.builder().status(ExceptionMessage.Bad_Request).build();

      }
      return Response.builder().status(ExceptionMessage.DataIsEmpty).build();

    } catch (Exception exception) {
      return Response.builder().res(exception.getMessage()).status(ExceptionMessage.Exception)
        .build();
    }
  }

  @PostMapping("/search")
  public Response getAllFullFillGridData(
    @Valid @RequestBody ReportsSearchTemplate reportsSearchTemplate) {
    checkNotNull(reportsSearchTemplate, " is required but found null");

    return reportsService.getReportsRequestBasedOnSearchTemplate(reportsSearchTemplate);
  }


}

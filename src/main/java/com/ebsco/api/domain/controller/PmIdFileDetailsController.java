package com.ebsco.api.domain.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.service.PmIdFileDetailsService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.PmIdFileDetailsDto;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.PmIdFileDetails;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.data.validation.DtoValidationUtils.Optionality;
import com.ebsco.transformer.PmIdFieldsTransformer;
import io.swagger.annotations.Api;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Objects;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping("/raft/pmidfields")
@Api(description = "This to perform all the related operations with respect to the PmIdFileDetails")
@RestController

public class PmIdFileDetailsController {

  @Autowired
  private PmIdFileDetailsService pmIdFileDetailsService;

  @RequestMapping(method = RequestMethod.POST, value = "save")
  public Response savePmIdFileDetails(@Valid
  @RequestBody PmIdFileDetailsDto pmIdFileDetailsDto) {
    DtoValidationUtils.validate(pmIdFileDetailsDto, Optionality.REQUIRED);
    PmIdFileDetails pmIdFileDetails = PmIdFieldsTransformer.toPmIdFileDetails(pmIdFileDetailsDto);
    if (Objects.nonNull(pmIdFileDetails)) {
      pmIdFileDetails.setUploadedDate(Timestamp.from(Instant.now()));
      PmIdFileDetails savedPmIdFileDetails = pmIdFileDetailsService
        .savePmIdFileDetails(pmIdFileDetails);

      PmIdFileDetailsDto savedPmIdFileDetailsDto = PmIdFieldsTransformer
        .toPmIdFileDetailsDto(savedPmIdFileDetails);

      return Response.builder()
        .result(savedPmIdFileDetailsDto)
        .status(ExceptionMessage.Created)
        .res("File Details saved successfully")
        .build();
    }
    return Response.builder()
      .status(ExceptionMessage.DataIsEmpty)
      .res("given file is empty")
      .build();

  }

  @RequestMapping(method = RequestMethod.PUT, value = "/update/{fileId}/{deletedBy}")
  public Response updatePmIdFileDetails(@PathVariable Long fileId, @PathVariable String deletedBy) {
    if (Objects.isNull(fileId)) {

      return Response.builder()
        .status(ExceptionMessage.DataIsEmpty)
        .res("given fileId is empty")
        .build();
    }

    return pmIdFileDetailsService.updatePmIdFileDetails(fileId, deletedBy);

  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/deleteByid/{fileId}")
  public Response deleteByFileId(@PathVariable Long fileId) {
    return pmIdFileDetailsService.deleteByFileId(fileId);


  }

  @GetMapping(value = "/filter/pmid/{pmId}/type/{type}")
  public Response getPmIdFileDetailsBasedOnPmIdAndType(@PathVariable Integer pmId,
    @PathVariable String type) {
    checkNotNull(pmId, "pmId must be required but found null");
    checkNotNull(type, "file type must be required but found null");

    return pmIdFileDetailsService.getPmIdFileIdDetailsByPmIdAnd(pmId, type);
  }


}

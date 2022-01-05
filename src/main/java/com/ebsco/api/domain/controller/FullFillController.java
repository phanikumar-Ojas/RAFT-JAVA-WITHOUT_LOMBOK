package com.ebsco.api.domain.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.service.FullFillService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.template.FullFillSearchTemplate;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.Response;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/raft/fullFill")
@Api(description = "This is a fullFill Controller which is used to use the operations of fullFill Page")
public class FullFillController {

  @Autowired
  FullFillService fullFillService;


  @GetMapping("/gridData")
  public Response getGridData() {
    List<FullTextRequestDto> fullFillServiceGridData = fullFillService.getGridData();
    return Response.builder().result(fullFillServiceGridData).status(ExceptionMessage.OK).build();
  }


  @PostMapping("/search")
  public Response getAllFullFillGridData(
    @Valid @RequestBody FullFillSearchTemplate fullFillSearchTemplate) {
    checkNotNull(fullFillSearchTemplate, "fullFillSearchTemplate is required but found null");

    return fullFillService.getFullFillRequestBasedOnSearchTemplate(fullFillSearchTemplate);
  }


}

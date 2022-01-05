package com.ebsco.api.domain.controller;

import com.ebsco.api.domain.service.FullTextService;
import com.ebsco.api.domain.service.FullTextUtilService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.FullTextRequestDto;
import com.ebsco.data.dto.FullTextRequestDtoList;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.FullTextRequest;
import com.ebsco.data.model.FullTextRequests;
import com.ebsco.data.template.FullTextSearchTemplate;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.data.validation.DtoValidationUtils.Optionality;
import com.ebsco.transformer.FullTextTransformer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "This Controller is used for the fullText service Operations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@RestController
@RequestMapping(value = {"raft/fulltext"})
public class FullTextController {
 private static final Logger log= LoggerFactory.getLogger(FullTextController.class);

  @Autowired
  FullTextService service;

  @Autowired
  FullTextUtilService fullTextUtilService;

//  @Autowired
//  private RabbitMQSender rabbitMQSender;


  @ApiOperation(value = "Gets all the PMid fields based on the given pmids")
  @ApiResponses(value = {@ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 200, message = "Data retrieved successfully")})
  @GetMapping("/search/{ids}/{userName}")
  public ResponseEntity<?> get(
    @ApiParam(value = "for this you need to send the multiple PMids seperated with comma") @PathVariable @Valid @NotNull String ids,
    @PathVariable @Valid @NotNull String userName) {
    DtoValidationUtils.validate(ids, Optionality.REQUIRED);
    DtoValidationUtils.validate(userName, Optionality.REQUIRED);

    log.debug(String.format("Given input for the PM ids {%s}", ids));
    List<Integer> processedPmIds = fullTextUtilService.processIds(ids);
    List<FullTextRequestDto> fullTextRequestDtos = Collections.emptyList();
    if (Objects.nonNull(processedPmIds) && !processedPmIds.isEmpty()) {

      fullTextRequestDtos = service.findByPmId(processedPmIds, userName);

      return ResponseEntity.ok(fullTextRequestDtos);
    } else {
      return ResponseEntity.noContent().build();
    }

  }

  @ApiOperation(value = "search mechanism for fullTextRequest based on the given searchedTemplate")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "all fullTextRequests retrived Successfully based on given searchTemplate")})
  @PostMapping("/search")
  public Response getAllFullTextRequests(
    @Valid @RequestBody FullTextSearchTemplate searchTemplate) {
    DtoValidationUtils.validateFullTextSearch(searchTemplate);
    Response response = service.searchForRequests(searchTemplate);
//    rabbitMQSender.send(response);
    return response;

  }

  @ApiOperation(value = "to get the latest 10 records from the database")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "latest 10 records are retrived Successfully "),
    @ApiResponse(code = 204, message = "no data found retrieve")})
  @GetMapping("/gridData")
  public Response getLatest10Records() {

    List<FullTextRequest> latest10Records = service.getLatest10Records();
    if (Objects.nonNull(latest10Records) && !CollectionUtils.isEmpty(latest10Records)) {

      return Response.builder().httpStatus(HttpStatus.NO_CONTENT).result(latest10Records)
        .res("data retrived Successfully").build();

    }
    return Response.builder().httpStatus(HttpStatus.NO_CONTENT)
      .res("NO data to retrive from Database").build();


  }

  @ApiOperation(value = "saving fullTextRequest object when it needs to be saved")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "fulltextRequestSaved successfully!")})
  @PostMapping("/save")
  public Response saveFullTextRequests(@Valid @RequestBody FullTextRequestDto fullTextRequestDto) {

    DtoValidationUtils.validate(fullTextRequestDto, Optionality.REQUIRED);
    FullTextRequest fullTextRequest = FullTextTransformer
      .toFullTextRequest(fullTextRequestDto);
    FullTextRequest savedFullTextRequest = service.save(fullTextRequest);
    return Response.builder().result1(savedFullTextRequest)
      .status(ExceptionMessage.Created).res("fullTextRequest saved successfully").build();

  }


  @ApiOperation(value = "saving fullTextRequest object when it needs to be saved")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "fulltextRequests Saved successfully!")})
  @PostMapping("/saveAll")
  public Response saveMultipleFullTextRequests(
    @Valid @RequestBody FullTextRequestDtoList fullTextRequestDtoList) {
    if (Objects.isNull(fullTextRequestDtoList) || CollectionUtils
      .isEmpty(fullTextRequestDtoList.getFullTextRequestDtoList())) {

      return Response.builder().status(ExceptionMessage.DataIsEmpty)
        .httpStatus(HttpStatus.NO_CONTENT).build();
    }
    List<FullTextRequestDto> fullTextRequestDtos = new ArrayList<>();

    for (FullTextRequestDto fullTextRequestDto : fullTextRequestDtoList
      .getFullTextRequestDtoList()) {

      FullTextRequest fullTextRequest = FullTextTransformer
        .toFullTextRequest(fullTextRequestDto);
      FullTextRequest savedFullTextRequest = service.save(fullTextRequest);
      fullTextRequestDtos.add(FullTextTransformer.fromFullTextRequest(savedFullTextRequest));
    }
    return Response.builder().result1(fullTextRequestDtos)
      .status(ExceptionMessage.Created).res("fullTextRequests saved successfully").build();

  }

  @ApiOperation(value = "It will gets the fulltextRequest or updates some fileds for fullTextRequest based on the given fullTextRequestId")
  @ApiResponses(value = {
    @ApiResponse(code = 202, message = "fullTextRequest Details retrieved or updated successfully"),
    @ApiResponse(code = 204, message = "fullTextRequest not found based on the given fullTextId")})
  @GetMapping("/get/{id}/{isFetchable}")
  public Response getFullTextRequestByRequestId(@PathVariable("id") Integer fullTextId,
    @PathVariable("isFetchable") boolean isFetchable) {
    DtoValidationUtils.validate(fullTextId, Optionality.REQUIRED);
    log.debug("The Requested Id:" + fullTextId);

    FullTextRequest fullTextRequestById = service.getFullTextRequestById(fullTextId, isFetchable);
    if (Objects.nonNull(fullTextRequestById)) {
      if (isFetchable) {
        return Response.builder().result(fullTextRequestById)
          .res("fullTextRequest Details Retrieved successfully").status(ExceptionMessage.Accepted)
          .build();
      } else {
        return Response.builder().result(fullTextRequestById).status(ExceptionMessage.Accepted)
          .res("fullTextRequest is updated successfully!!").build();
      }

    }
    return Response.builder().status(ExceptionMessage.DataIsEmpty)
      .res("a FullTextRequest is not found with the given id:" + fullTextId)
      .httpStatus(HttpStatus.NO_CONTENT).build();

  }


  @GetMapping("/toxml")
  public ResponseEntity<?> formatXmlFromList() {

//		Files.write(Paths.get(""), null, options)

    List<FullTextRequest> findAll = service.findAll();
    try {
      // create an instance of `JAXBContext`
      JAXBContext context = JAXBContext.newInstance(FullTextRequests.class);

      // create an instance of `Marshaller`
      Marshaller marshaller = context.createMarshaller();

      // enable pretty-print XML output
      marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      // create XML file
      File file = new File("./book.xml");

      // convert book object to XML file
      marshaller.marshal(FullTextRequests.builder().fullTextRequest(findAll).build(), file);
      return ResponseEntity.ok(findAll);

    } catch (JAXBException ex) {
      ex.printStackTrace();
      return ResponseEntity.badRequest().build();
    }

  }
}

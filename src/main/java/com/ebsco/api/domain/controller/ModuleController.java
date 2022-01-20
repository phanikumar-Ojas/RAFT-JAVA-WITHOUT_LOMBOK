package com.ebsco.api.domain.controller;

import static com.google.common.base.Preconditions.checkArgument;

import com.ebsco.api.domain.service.ModuleService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.template.ModuleSearchTemplate;
import java.net.URI;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Module;
import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.data.exception.ModuleDataNotFoundException;
import com.ebsco.transformer.ModuleTransformer;
import com.ebsco.data.validation.DtoValidationUtils;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "this Controller is used to perform all the operations which can be performed by Module", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/raft/module")
public class ModuleController {

  @Autowired
  @Qualifier(value = "v1ModuleServiceImpl")
  private ModuleService moduleService;

//	@Autowired
//	private RabbitMQSender rabbitMQSender;

  @PostMapping("/search")
  @ApiOperation(value = "this endppint is used to search the modules based on the given searchTemplate")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "list of modules data retrieved successfully!!"),
    @ApiResponse(code = 400, message = "unExcpected error occured because of bad Request given")})
  public ResponseEntity<Object> moduleDataSearch(
    @NotNull @RequestBody ModuleSearchTemplate searchTemplate) {

    DtoValidationUtils.validateModuleSearch(searchTemplate);
    Response response = moduleService
      .getAllModules(searchTemplate.getPageSize(), searchTemplate.getPageNumber());
//			rabbitMQSender.send(response);
    if (Objects.nonNull(response.getResult())) {
      return ResponseEntity.ok(response);
    } else {
      throw new ModuleDataNotFoundException("Module Data is not found");
    }
  }

  @PostMapping("/v1/save")
  @ApiOperation(value = "this endppint is used to save or update the given module")
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "module Data is created or updated successfully!!"),
    @ApiResponse(code = 400, message = "unExcpected error occured because of bad Request given")})
  public ResponseEntity<Object> saveModule(@Valid @RequestBody ModuleDTO dto) {
    DtoValidationUtils.validateModule(dto);
    Response response = Response.builder().build();
    Module savedModule = moduleService.saveModule(dto);
    response.setResult(savedModule);
    response.setHttpStatus(HttpStatus.CREATED);
    response.setRes("The Module is successfully created or Updated");
    if (Objects.nonNull(savedModule)) {
      response.setResult(ModuleTransformer.fromEntityToDTO(savedModule));
      return ResponseEntity.created(URI.create("raft/module/v1/save")).body(response);
    } else {
      throw new DataNotFoundException("Data is not saved");
    }

  }

  @PostMapping("/byParentIds")
  public ResponseEntity<?> getModulesByParentIds(@RequestBody @Valid List<Integer> parentIds) {
    return ResponseEntity.ok(moduleService.getModulesByParentIds(parentIds));
  }

  @DeleteMapping("/delete/{moduleId}")
  public Response deleteModuleById(@PathVariable Integer moduleId) {
    checkArgument(moduleId != null && moduleId > 0, "moduleId must be a valid number");
    try {
      moduleService.deleteModuleById(moduleId);
      return Response.builder().status(ExceptionMessage.OK)
        .res(String.format("modue deleted with the id:%d", moduleId)).build();
    } catch (Exception exception) {
      return Response.builder().status(ExceptionMessage.Exception).res(exception.getMessage())
        .build();
    }
  }

  @GetMapping("/findAll")
  @ApiOperation(value = "this service is used to find all the module details.")
  public Response findAll() {
    try {
      List<Module> allModules = moduleService.getAllModules();
      return Response.builder().status(ExceptionMessage.OK).result(allModules).build();
    } catch (Exception exception) {
      return Response.builder().status(ExceptionMessage.Exception).res(exception.getMessage())
        .build();
    }
  }

}

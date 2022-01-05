package com.ebsco.api.domain.controller;

import com.ebsco.data.template.RolesSearchTemplate;
import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ebsco.data.dto.Response;
import com.ebsco.data.dto.RoleDTO;
import com.ebsco.data.entity.Role;
import com.ebsco.api.domain.service.RolesService;
import com.ebsco.transformer.RolesTransformer;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.data.validation.DtoValidationUtils.Optionality;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(description = "This Controller is used for the Roles Operations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@RequestMapping("/raft/roles")
public class RolesController {

  @Autowired
  private RolesService rolesService;

  //23092021 Venkat Role Save Service
  
  @PostMapping("/save")
  @ApiOperation(value = "This end point is used to save or update a record for role in DB")
  @ApiResponses(value = {
    @ApiResponse(code = 201, message = "Role is successfully created or updated"),
    @ApiResponse(code = 500, message = "some internal error occured")})
  @Transactional(rollbackFor = Exception.class)
  public ResponseEntity<?> save(
    @NotNull @NotBlank @Valid @RequestBody @ApiParam(value = "this contains same fields which are available in Roles and used for saving or updating Roles") RoleDTO dto) {

    DtoValidationUtils.validateRole(dto);
    Response response = Response.builder().build();
    Role role = RolesTransformer.fromDtoToEntity(dto);

    response = rolesService.save(role);
    return ResponseEntity.created(URI.create("/raft/roles/save")).body(response);

  }
  
  
  //23092021 Venkat Role Fetch Service

  @ApiOperation(value = "This is to retrieve the role based on the given roleID")
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "the role with the given id successfully retrieved"),
    @ApiResponse(code = 204, message = "No Role found with the given id")})
  @GetMapping("/get/{roleId}")
  public ResponseEntity<?> getRoleById(@PathVariable String roleId) {
    DtoValidationUtils.validate(roleId, Optionality.REQUIRED);
    Role role = rolesService.findById(roleId);
    if (role != null) {
      return ResponseEntity.ok(role);
    } else {
      return ResponseEntity.noContent().build();
    }

  }
  
  
  //23092021 Venkat Fetch All Roles Service based on Pagination

  @PostMapping(value = {"search", "/v1/search"})
  @ApiOperation(value = "This is to get all the Roles based on the rolesSearch")
  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "Data not retrieved because of Bad SearchTemplate Request"),
    @ApiResponse(code = 200, message = "roles data retrieved successfully!")})
  public ResponseEntity<?> getAllRoles(
    @NotNull @Valid @RequestBody @ApiParam(name = "searchTemplate", value = "This searchTemplate contains of pageNumber and pageSize and mutiple fields which are required to search in different controllers") RolesSearchTemplate searchTemplate) {
    Response response;

    DtoValidationUtils.validateRolesSearch(searchTemplate);

    response = rolesService.findAll(searchTemplate.getPageSize(), searchTemplate.getPageNumber());
    return ResponseEntity.ok(response);

  }

}

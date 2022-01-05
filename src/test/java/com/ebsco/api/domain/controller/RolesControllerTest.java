package com.ebsco.api.domain.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ebsco.data.template.RolesSearchTemplate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.dto.RoleDTO;
import com.ebsco.data.entity.Module;
import com.ebsco.data.entity.Role;
import com.ebsco.data.exception.DataValidationException;
import com.ebsco.api.domain.service.RolesService;
import com.ebsco.data.exception.DataFormattingException;
import com.ebsco.data.exception.InvalidRoleDataException;

public class RolesControllerTest {

	@InjectMocks
	RolesController rolesContoller;

	@Mock
	private RolesService rolesService;

	Module module;
	Module module1;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);
		module = new Module();
		module1 = new Module(1, "aaa", module, "path", "icon", "imagepath", 123, true);

	}

	@Test
	public void test_roleSave_success() {
		Response response = new Response();
		response.setResult(getRoles());
		response.setHttpStatus(HttpStatus.CREATED);
		response.setStatus(ExceptionMessage.Created);
		when(rolesService.save(getRoles())).thenReturn(response);
		ResponseEntity<?> save = rolesContoller.save(getRoleDto());
		assertEquals(response, save.getBody());
	}

	@Test
	public void test_roleSave_withWrongId() {
		RoleDTO dto = RoleDTO.builder().roleid("abcd").rolename("roleName").build();

		DataFormattingException exception = assertThrows(DataFormattingException.class, () -> rolesContoller.save(dto));
		assertEquals(exception.getMessage(), "This property must contain only Number but found String");
	}

	@Test
	public void test_rolesave_nullRole_shouldThrowInvalidRoleDataException() {
		RoleDTO dto = RoleDTO.builder().build();
		InvalidRoleDataException exception = assertThrows(InvalidRoleDataException.class,
				() -> rolesContoller.save(null));
		assertEquals(exception.getMessage(), "The Required data for creating role is not found");

	}

	@Test
	public void test_rolesave_withoutRole_shouldhrowDataValidationException() {

		RoleDTO dto = RoleDTO.builder().build();
		DataValidationException exception = assertThrows(DataValidationException.class, () -> rolesContoller.save(dto));
		assertEquals(exception.getMessage(), "The Required value is not found");
	}

	@Test
	public void test_rolesave_BlankRole_shouldhrowDataValidationException() {

		RoleDTO dto = RoleDTO.builder().roleid(" ").rolename(" ").build();
		DataValidationException exception = assertThrows(DataValidationException.class, () -> rolesContoller.save(dto));
		assertEquals(exception.getMessage(), "The Value is required but found Blank");
	}

	@Test
	public void test_rolesave_emptyRole_shouldhrowDataValidationException() {

		RoleDTO dto = RoleDTO.builder().roleid("").rolename("").build();
		DataValidationException exception = assertThrows(DataValidationException.class, () -> rolesContoller.save(dto));
		assertEquals(exception.getMessage(), "The Value is required but found Empty");
	}

	@Test
	public void test_getById_success() {
		when(rolesService.findById("1")).thenReturn(getRoles());
		ResponseEntity<?> roleById = rolesContoller.getRoleById("1");
		assertEquals(getRoles(), roleById.getBody());

	}

	@Test
	public void test_getByIdNull_retun204StatusCode() {
		when(rolesService.findById("2")).thenReturn(null);
		ResponseEntity<?> roleById = rolesContoller.getRoleById("2");
		assertEquals(HttpStatus.NO_CONTENT, roleById.getStatusCode());

	}

	@Test
	public void test_getAllRoles_success() {
		Response response = new Response();
		response.setResult(getRoles());
		response.setTotalPages(1);
		response.setTotalRecords(2);
		response.setStatus(ExceptionMessage.OK);
		when(rolesService.findAll(1, 2)).thenReturn(response);
		ResponseEntity<?> allRoles = rolesContoller.getAllRoles(getRolesSearchTemplate());
		assertEquals(HttpStatus.OK, allRoles.getStatusCode());

	}

	@Test
	public void test_getAllRoles_withSearchTemplateNull_ShouldThrowDataNotFoundException() {
    DataValidationException exception = assertThrows(DataValidationException.class,
				() -> rolesContoller.getAllRoles(null));

		assertEquals(exception.getMessage(), "The Required value is not found");

	}

	@Test
	public void test_getAllRoles_withSearchTemplateWithNullPageNumber_ShouldThrowDataValidationException() {
		RolesSearchTemplate searchTemplate = RolesSearchTemplate.builder().pageSize(2).build();
		DataValidationException exception = assertThrows(DataValidationException.class,
				() -> rolesContoller.getAllRoles(searchTemplate));

		assertEquals(exception.getMessage(), "The PageNumber Value is required but found null");

	}

	@Test
	public void test_getAllRoles_withSearchTemplateWithNullPageSize_ShouldThrowDataValidationException() {
    RolesSearchTemplate searchTemplate = RolesSearchTemplate.builder().pageNumber(1).build();
		DataValidationException exception = assertThrows(DataValidationException.class,
				() -> rolesContoller.getAllRoles(searchTemplate));

		assertEquals(exception.getMessage(), "The PageSize Value is required but found null");

	}

	public List<Module> getModules() {
		List<Module> listModule = new ArrayList<Module>();
		listModule.add(module1);
		return listModule;

	}

	public Role getRoles() {
		Role role = new Role(1, "admin", true, true, getModules());
		return role;
	}

	public RoleDTO getRoleDto() {
		RoleDTO roleDto = new RoleDTO("1", "admin", true, true, getModules());
		return roleDto;
	}

  public RolesSearchTemplate getRolesSearchTemplate() {
    return RolesSearchTemplate.builder().pageNumber(1).pageSize(2).build();

	}

}

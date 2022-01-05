package com.ebsco.api.domain.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import com.ebsco.data.template.UserSearchTemplate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ebsco.data.dto.Response;
import com.ebsco.data.dto.UsersDTO;
import com.ebsco.data.entity.Module;
import com.ebsco.data.entity.Role;
import com.ebsco.data.entity.UserDetails;
import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.data.exception.DataValidationException;
import com.ebsco.data.model.Login;
import com.ebsco.api.domain.service.UserService;

public class UserControllerTest {

	@InjectMocks
	UserController userController;

	@Mock
	UserService userService;

	Module module;
	Module module1;
	Role role;
	Login login;

	@BeforeEach
	public void before() {
		MockitoAnnotations.openMocks(this);

		module = new Module();
		module1 = new Module(1, "aaa", module, "path", "icon", "imagepath", 123, true);
		role = new Role(1, "admin", true, true, getModules());
		login = new Login("aldo", "abc1234");
	}

	@Test
	public void test_saveUser_success() {
		Response response = new Response();
		response.setHttpStatus(HttpStatus.CREATED);
		when(userService.save(getUser())).thenReturn(getUser());
		Response saveModule = userController.saveUser(userDto());
		assertEquals(response.getHttpStatus(), HttpStatus.CREATED);
	}

	@Test
	public void test_saveUser_nullRole_shouldThrowDataValidationException() {
		UsersDTO userDto = UsersDTO.builder().build();
		DataValidationException exception = assertThrows(DataValidationException.class,
				() -> userController.saveUser(null));
		assertEquals(exception.getMessage(), "The data used to create a user is required but found null");

	}

	@Test
	public void test_login_success() {
		when(userService.findByUserNameAndPassword(ArgumentMatchers.any(), ArgumentMatchers.any()))
				.thenReturn(getUser());
		ResponseEntity<?> login = userController.login(getLogin());
		assertEquals(userDto(), login.getBody());

	}

	@Test
	public void test_loginNull() {
    DataNotFoundException exception = assertThrows(DataNotFoundException.class,
      () -> userController.login(null));
    assertEquals(exception.getMessage(), "login details required but found null");

  }

	@Test
	public void test_loginnull_shouldReturnDataNotFoundException() {
		DataNotFoundException exception = assertThrows(DataNotFoundException.class, () -> userController.login(null));
		assertEquals(exception.getMessage(), "login details required but found null");
	}

	@Test
	public void test_UserSearch_success() {
    Response response = new Response();
    response.setTotalPages(1);
    response.setTotalRecords(2);
    when(userService.findAll(getUserSearchTemplate())).thenReturn(response);
    Response userSearch = userController.userSearch(getUserSearchTemplate());
    assertEquals(response.getHttpStatus(), userSearch.getHttpStatus());
  }

	public List<Module> getModules() {
		List<Module> listModule = new ArrayList<Module>();
		listModule.add(module1);
		return listModule;

	}

	public List<Role> getRoles() {
		List<Role> listRole = new ArrayList<Role>();
		listRole.add(role);
		return listRole;

	}

	public UsersDTO userDto() {
		UsersDTO userDto = new UsersDTO(1, "abc@gmail.com", "abc1234", true, "aldo", true, "zxy@gmail.com",
				"costcenter", getRoles());
		return userDto;

	}

	public UserDetails getUser() {
		UserDetails user = new UserDetails(1, "abc@gmail.com", "abc1234", true, "aldo", true, "zxy@gmail.com",
      "costcenter", getRoles());
    return user;

  }

  public Login getLogin() {
    Login login = new Login("aldo", "abc1234");
    return login;
  }

  public Login getWrongLogin() {
    Login login = new Login("aldo", "abc1234");
    return login;
  }

  public UserSearchTemplate getUserSearchTemplate() {
    return UserSearchTemplate.builder().pageNumber(1).pageSize(2).build();

  }


}

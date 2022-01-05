package com.ebsco.api.domain.controller;

import static com.google.common.base.Preconditions.checkNotNull;

import com.ebsco.api.domain.service.UserService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.dto.UsersDTO;
import com.ebsco.data.entity.UserDetails;
import com.ebsco.data.model.Login;
import com.ebsco.data.template.UserSearchTemplate;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.data.validation.DtoValidationUtils.Optionality;
import com.ebsco.transformer.UserDetailsTransformer;
import com.ebsco.data.dto.ResetPasswordDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(description = "This Controller is used to perform  User Related Operations", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
@RestController
@RequestMapping("raft/userServices")
public class UserController {

  private static final Logger log= LoggerFactory.getLogger(UserController.class);

  @Autowired
	UserService service;

	@PostMapping(value = "/login")
	@ApiOperation(consumes = "application/json", value = "Login service")
	public ResponseEntity<?> login(@Valid @NotNull @RequestBody Login login) {
		DtoValidationUtils.validateLogin(login);
		UserDetails value = null;
		value = service.findByUserNameAndPassword(login.getUserName(), login.getPassword());

		if (Objects.isNull(value)) {
      return ResponseEntity.badRequest().body(Response.builder().res("User Not found").build());
    }
//		Response response = new Response(ExceptionMessage.OK, UserDetailsTransformer.fromEntityToDto(value));
		return ResponseEntity.ok(UserDetailsTransformer.fromEntityToDto(value));
	}


	//20210920 Venkat Manage Button User Creation Service

  @ApiResponses(value = {
    @ApiResponse(code = 400, message = "User Not Saved beacuase of Bad Request"),
    @ApiResponse(code = 201, message = "User created Successfully!!")})

  @PostMapping("/save")
  @ApiOperation(consumes = "application/json", produces = "application/json", value = "User Save Service")
  public Response saveUser(
    @ApiParam(name = "users", value = "This is the DTO which is related to User Saving") @Valid @NotNull @RequestBody UsersDTO userDTO) {
    DtoValidationUtils.validateUser(userDTO);

    UserDetails savedUserDetails = service.save(UserDetailsTransformer.fromDtoToUser(userDTO));

    return new Response(ExceptionMessage.Created, savedUserDetails);
  }

  @PostMapping("/search")
  @ApiOperation(consumes = "application/json", value = "This is to get the list of users based on the pageNumber and pageSize")
  public Response userSearch(@Valid @NotNull @RequestBody UserSearchTemplate search) {

    return service.findAll(search);

  }

  @GetMapping("/forgotpassword/{email}")
  public Response forgotPasword(@PathVariable("email") String email) {
    DtoValidationUtils.validate(email, Optionality.REQUIRED);
    return service.forgotPassword(email);
  }

  @PutMapping("/updatePassword")
  public Response updatePassword(@RequestBody ResetPasswordDto resetPasswordDto) {
    checkNotNull(resetPasswordDto, "resetPasswordDto required but found null");

    return service.updatePassword(resetPasswordDto);

  }


}

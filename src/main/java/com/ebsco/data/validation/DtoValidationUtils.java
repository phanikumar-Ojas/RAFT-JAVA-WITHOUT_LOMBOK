package com.ebsco.data.validation;

import com.ebsco.data.dto.EmailDetails;
import com.ebsco.data.template.FullTextSearchTemplate;
import com.ebsco.data.template.ModuleSearchTemplate;
import com.ebsco.data.template.RolesSearchTemplate;
import com.ebsco.data.exception.DataFormattingException;
import com.ebsco.data.exception.EmailDataException;
import com.ebsco.data.exception.InvalidRoleDataException;
import com.google.common.base.Strings;
import java.util.Objects;

import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.dto.RoleDTO;
import com.ebsco.data.dto.UsersDTO;
import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.data.exception.DataValidationException;
import com.ebsco.data.model.Login;

public class DtoValidationUtils {

  private static final String EMAIL_PATTERN = "^(.+)@(.+)$";

  public static void validate(Object string, Optionality optionality) {

    if (optionality == Optionality.REQUIRED) {

      if (string == null) {
        throw new DataValidationException("The Required value is not found");
      }
      if (string instanceof String) {
        if (StringUtils.isEmpty(String.valueOf(string))) {
          throw new DataValidationException("The Value is required but found Empty");
        }
        if (StringUtils.isBlank(String.valueOf(string))) {
          throw new DataValidationException("The Value is required but found Blank");
        }
      }
    }
	}

  public static void validateLogin(Login login) {

    if (Objects.isNull(login)) {
      throw new DataNotFoundException("login details required but found null");
    }

    validate(login.getUserName(), Optionality.REQUIRED);
    validate(login.getPassword(), Optionality.REQUIRED);

  }


  public static void validateModuleSearch(ModuleSearchTemplate searchTemplate) {
    validate(searchTemplate, Optionality.REQUIRED);
    validatePageNumber(searchTemplate.getPageNumber());
    validatePageSize(searchTemplate.getPageSize());
  }

  private static void validatePageNumber(Integer pageNumber) {
    if (Objects.isNull(pageNumber)) {
      throw new DataValidationException("The PageNumber Value is required but found null");
    }
  }

  private static void validatePageSize(Integer pageSize) {
    if (Objects.isNull(pageSize)) {
      throw new DataValidationException("The PageSize Value is required but found null");
    }
  }

  public static void validateFullTextSearch(FullTextSearchTemplate searchTemplate) {
    if (Objects.isNull(searchTemplate)) {
      throw new DataNotFoundException("Search criteria data is not found");
    }

    validatePageNumber(searchTemplate.getPageNumber());
    validatePageSize(searchTemplate.getPageSize());

    if (Objects.nonNull(searchTemplate.getFrom())) {
      if (Objects.isNull(searchTemplate.getTo())) {
        throw new DataValidationException("to date must be required when from is present");
      }
    }

  }

  public static void validatePageNumberAndPageSize(Integer pageNumber, Integer pageSize) {

    if (Objects.nonNull(pageNumber)) {
      if (Objects.isNull(pageSize)) {
        throw new DataValidationException("pageNumber is present but pageSize is not present");
      }
    }

    if (Objects.nonNull(pageSize)) {
      if (Objects.isNull(pageNumber)) {
        throw new DataValidationException("pageSize is present but pageNumber is not present");
      }
    }
  }

  public static void validateRole(RoleDTO dto) {
    if (Objects.isNull(dto)) {
      throw new InvalidRoleDataException("The Required data for creating role is not found");
    }
    validate(dto.getRolename(), Optionality.REQUIRED);
    if (dto.getRoleid() != null && !NumberUtils.isCreatable(dto.getRoleid())) {
      throw new DataFormattingException("This property must contain only Number but found String");
    }

  }

  public static void validateRolesSearch(RolesSearchTemplate searchTemplate) {
    validate(searchTemplate, Optionality.REQUIRED);
    validatePageNumber(searchTemplate.getPageNumber());
    validatePageSize(searchTemplate.getPageSize());
  }

  public static void validateUser(UsersDTO userDTO) {

    if (Objects.isNull(userDTO)) {
      throw new DataValidationException(
        "The data used to create a user is required but found null");

    }

  }

  private static void validateEntity(Object obj) {
    if (Objects.isNull(obj)) {

    }
  }

  public static void validateModule(ModuleDTO dto) {
    if (Objects.isNull(dto)) {
      throw new DataNotFoundException(
        "The data used to create a module is required but found null");

    }
    validate(dto.getModuleName(), Optionality.REQUIRED);
  }

  public static void validateEmail(EmailDetails emailDetails) {
    if (!Objects.isNull(emailDetails)) {
      validateToAddress(emailDetails.getTo());
      validateEmailId(emailDetails.getEmail());

    } else {
      throw new EmailDataException("EmailDetails required to send the mail but found empty");
    }
  }

  public static void validateEmailId(String emailId) {
    if (Strings.isNullOrEmpty(emailId)) {
      throw new EmailDataException("Email address must be required but found null or empty");
    }
    if (StringUtils.isBlank(emailId)) {
      throw new EmailDataException("Email address must be required but found blank");
    }
    boolean matches = Pattern.compile(EMAIL_PATTERN).matcher(emailId).matches();
    if (!matches) {
      throw new EmailDataException("Email address must be valid but found in valid");
    }

  }


  public static void validateToAddress(String toAddress) {
    if (Strings.isNullOrEmpty(toAddress)) {
      throw new EmailDataException("To address must be required but found null or empty");
    }
    if (StringUtils.isBlank(toAddress)) {
      throw new EmailDataException("To address must be required but found blank");
    }


  }

  public enum Optionality {
    REQUIRED, OPTIONAL;
  }

}

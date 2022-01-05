package com.ebsco.data.exception.handler;

import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.data.exception.DataValidationException;
import com.ebsco.data.exception.ModuleDataNotFoundException;
import com.ebsco.data.exception.URLValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import com.ebsco.data.dto.ErrorDto;
import com.ebsco.data.exception.DataFormattingException;
import com.ebsco.data.exception.FullTextRequestDataNotFoundException;
import com.ebsco.data.exception.InvalidRoleDataException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class CustomnExceptionHandlers {


  @ExceptionHandler(DataValidationException.class)
  public ResponseEntity<ErrorDto> dataValidationExceptionHandler(WebRequest httpRequest,
    DataValidationException dataValidationException) {

    return handle(dataValidationException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));
  }

  @ExceptionHandler(URLValidationException.class)
  public ResponseEntity<ErrorDto> urlDataValidationExceptionHandler(WebRequest httpRequest,
    URLValidationException urlDataValidationException) {
    return handle(urlDataValidationException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));
  }

  @ExceptionHandler(ModuleDataNotFoundException.class)
  public ResponseEntity<ErrorDto> moduleDataNotFoundExceptionHandler(WebRequest httpRequest,
    ModuleDataNotFoundException moduleDataNotFoundException) {

    return handle(moduleDataNotFoundException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));
  }

  @ExceptionHandler(InvalidRoleDataException.class)
  public ResponseEntity<ErrorDto> invalidRoleDataExceptionHandler(WebRequest httpRequest,
    InvalidRoleDataException invalidRoleDataException) {

    return handle(invalidRoleDataException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));
  }

  @ExceptionHandler(DataFormattingException.class)
  public ResponseEntity<ErrorDto> dataFormattingExceptionHandler(WebRequest httpRequest,
    DataFormattingException dataFormattingException) {

    return handle(dataFormattingException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<ErrorDto> dataNotFoundExceptionHandler(WebRequest httpRequest,
    DataNotFoundException dataValidationException) {

    return handle(dataValidationException, HttpStatus.BAD_REQUEST, getRequestUri(httpRequest));

  }

  @ExceptionHandler(FullTextRequestDataNotFoundException.class)
  public ResponseEntity<ErrorDto> fullTextRequestDataNotFoundException(WebRequest httpRequest,
    FullTextRequestDataNotFoundException fullTextRequestDataNotFoundException) {

    return handle(fullTextRequestDataNotFoundException, HttpStatus.BAD_REQUEST,
      getRequestUri(httpRequest));

  }

  private String getRequestUri(WebRequest request) {
    String uri = null;
    if (request instanceof ServletWebRequest) {
      uri = String.valueOf(((ServletWebRequest) request).getHttpMethod());
      if (((ServletWebRequest) request).getRequest() != null) {
        uri += " " + ((ServletWebRequest) request).getRequest().getRequestURI();
      }
    }
    return uri;
  }

  @SuppressWarnings({ "unchecked", "rawtypes" })
	protected ResponseEntity<ErrorDto> handle(Throwable t, HttpStatus httpStatus, String requestUri) {
		String type = t.getClass().getSimpleName();
		String description = t.getMessage() != null ? t.getMessage() : "Unknown error";
		if (httpStatus.is5xxServerError())
			log.error(String.format("Encountered unexpected error (code: %s, type: %s, message: %s, uri: %s)",
					httpStatus, type, t.getMessage(), requestUri), t);
		else if (httpStatus != HttpStatus.NOT_FOUND)
			log.warn(String.format("Encountered unexpected error (code: %s, type: %s, message: %s, uri: %s)",
					httpStatus, type, t.getMessage(), requestUri));
		ErrorDto error = new ErrorDto();
		error.setStatusCode(httpStatus.value());
		error.setType(type);
		error.setDescription(description);
		return new ResponseEntity(error, httpStatus);
	}

}

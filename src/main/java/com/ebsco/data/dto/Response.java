package com.ebsco.data.dto;

import org.springframework.http.HttpStatus;

public class Response {
	private ExceptionMessage status;
	private String errorCode;
	private String errorMessage;
	private String exceptionType;
	private Object result;
	private Object result1;
	private HttpStatus httpStatus;
	private String status2;
	private String res;
	private Integer totalPages;
	private Integer totalRecords;
	private String encodedString;

	public Response(ExceptionMessage status, Object result, Object result1) {
		super();
		this.status = status;
		this.result = result;
		this.result1 = result1;
	}

	public Response(ExceptionMessage status, String res) {
		super();
		this.status = status;
		this.res = res;
	}

	public Response(ExceptionMessage status, Object result) {
		super();
		this.status = status;
		this.result = result;

	}

	public Response(ExceptionMessage status) {
		super();
		this.status = status;

	}

	public Response(Object result, ExceptionMessage status) {
		this.status = status;
		this.result = result;
	}

	public Response(ExceptionMessage status, String errorCode, String errorMessage, String exceptionType) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.exceptionType = exceptionType;
	}

	public Response(ExceptionMessage status, String errorCode, String errorMessage) {
		this.status = status;
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;

	}

	public Response(ExceptionMessage status, Object result, String encodedString) {
		super();
		this.status = status;
		this.result = result;
		this.encodedString = encodedString;
	}

	public Response(String status2, HttpStatus httpStatus, String res) {
		this.status2 = status2;
		this.res = res;
		this.httpStatus = httpStatus;

	}

	public Response(HttpStatus httpStatus, String res) {
		this.res = res;
		this.httpStatus = httpStatus;

	}

  public Response(ExceptionMessage status, String errorCode, String errorMessage,
    String exceptionType, Object result, Object result1, HttpStatus httpStatus, String status2,
    String res, Integer totalPages, Integer totalRecords, String encodedString) {
    this.status = status;
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.exceptionType = exceptionType;
    this.result = result;
    this.result1 = result1;
    this.httpStatus = httpStatus;
    this.status2 = status2;
    this.res = res;
    this.totalPages = totalPages;
    this.totalRecords = totalRecords;
    this.encodedString = encodedString;
  }

  public Response() {
  }

  public static ResponseBuilder builder() {
    return new ResponseBuilder();
  }

  public ExceptionMessage getStatus() {
    return this.status;
  }

  public String getErrorCode() {
    return this.errorCode;
  }

  public String getErrorMessage() {
    return this.errorMessage;
  }

  public String getExceptionType() {
    return this.exceptionType;
  }

  public Object getResult() {
    return this.result;
  }

  public Object getResult1() {
    return this.result1;
  }

  public HttpStatus getHttpStatus() {
    return this.httpStatus;
  }

  public String getStatus2() {
    return this.status2;
  }

  public String getRes() {
    return this.res;
  }

  public Integer getTotalPages() {
    return this.totalPages;
  }

  public Integer getTotalRecords() {
    return this.totalRecords;
  }

  public String getEncodedString() {
    return this.encodedString;
  }

  public void setStatus(ExceptionMessage status) {
    this.status = status;
  }

  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public void setExceptionType(String exceptionType) {
    this.exceptionType = exceptionType;
  }

  public void setResult(Object result) {
    this.result = result;
  }

  public void setResult1(Object result1) {
    this.result1 = result1;
  }

  public void setHttpStatus(HttpStatus httpStatus) {
    this.httpStatus = httpStatus;
  }

  public void setStatus2(String status2) {
    this.status2 = status2;
  }

  public void setRes(String res) {
    this.res = res;
  }

  public void setTotalPages(Integer totalPages) {
    this.totalPages = totalPages;
  }

  public void setTotalRecords(Integer totalRecords) {
    this.totalRecords = totalRecords;
  }

  public void setEncodedString(String encodedString) {
    this.encodedString = encodedString;
  }

  public String toString() {
    return "Response(status=" + this.getStatus() + ", errorCode=" + this.getErrorCode()
      + ", errorMessage=" + this.getErrorMessage() + ", exceptionType=" + this.getExceptionType()
      + ", result=" + this.getResult() + ", result1=" + this.getResult1() + ", httpStatus="
      + this.getHttpStatus() + ", status2=" + this.getStatus2() + ", res=" + this.getRes()
      + ", totalPages=" + this.getTotalPages() + ", totalRecords=" + this.getTotalRecords()
      + ", encodedString=" + this.getEncodedString() + ")";
  }

  public static class ResponseBuilder {

    private ExceptionMessage status;
    private String errorCode;
    private String errorMessage;
    private String exceptionType;
    private Object result;
    private Object result1;
    private HttpStatus httpStatus;
    private String status2;
    private String res;
    private Integer totalPages;
    private Integer totalRecords;
    private String encodedString;

    ResponseBuilder() {
    }

    public ResponseBuilder status(ExceptionMessage status) {
      this.status = status;
      return this;
    }

    public ResponseBuilder errorCode(String errorCode) {
      this.errorCode = errorCode;
      return this;
    }

    public ResponseBuilder errorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
      return this;
    }

    public ResponseBuilder exceptionType(String exceptionType) {
      this.exceptionType = exceptionType;
      return this;
    }

    public ResponseBuilder result(Object result) {
      this.result = result;
      return this;
    }

    public ResponseBuilder result1(Object result1) {
      this.result1 = result1;
      return this;
    }

    public ResponseBuilder httpStatus(HttpStatus httpStatus) {
      this.httpStatus = httpStatus;
      return this;
    }

    public ResponseBuilder status2(String status2) {
      this.status2 = status2;
      return this;
    }

    public ResponseBuilder res(String res) {
      this.res = res;
      return this;
    }

    public ResponseBuilder totalPages(Integer totalPages) {
      this.totalPages = totalPages;
      return this;
    }

    public ResponseBuilder totalRecords(Integer totalRecords) {
      this.totalRecords = totalRecords;
      return this;
    }

    public ResponseBuilder encodedString(String encodedString) {
      this.encodedString = encodedString;
      return this;
    }

    public Response build() {
      return new Response(status, errorCode, errorMessage, exceptionType, result, result1,
        httpStatus,
        status2, res, totalPages, totalRecords, encodedString);
    }

    public String toString() {
      return "Response.ResponseBuilder(status=" + this.status + ", errorCode=" + this.errorCode
        + ", errorMessage=" + this.errorMessage + ", exceptionType=" + this.exceptionType
        + ", result=" + this.result + ", result1=" + this.result1 + ", httpStatus="
        + this.httpStatus + ", status2=" + this.status2 + ", res=" + this.res + ", totalPages="
        + this.totalPages + ", totalRecords=" + this.totalRecords + ", encodedString="
        + this.encodedString + ")";
    }
  }
}

package com.ebsco.data.dto;

public enum ExceptionMessage {

	DataIsEmpty("message_DataIsEmpty")
  ,DataIsNotSaved("message_DataIsNotSaved")
  ,TokenIsEmpty("message_TokenIsEmpty")
  ,TokenIsInvalid("message_TokenIsInvalid")
  ,TokenIsExpire("message_TokenIsExpire")
	,ServerTimeOut("message_ServerTimeOut")
  ,UnAuthorizationUser("message_ UnAuthorizationUser")
	,UnRegistrationUser("message_ UnRegistrationUser")
  ,StatusSuccess("message_Success")
  ,DuplicateRecord("message_DuplicateRecord")
  ,EmailExist("message_Email_Exist")
  ,NameExist("message_Name_Exist")
	,PhoneExist("message_Phone_No_Exist")
  ,OK("200")
  ,Bad_Request("400")
  ,Accepted("202")
  ,Unauthorized("401")
	,Created("201")
  ,Not_Found("404")
  ,ExcepcetdDataNotAvilable("message_ExcepcetdDataNotAvilable")
	,DataLimitExceeded("User Limit Reached")
  ,Exception("500")
  ,EmailNotExist("message_Email_Not_Exist")
  ,PassWordLinkExpired("message_Reset_Password_Expired");

	private String exceptionMessage;

	public String getExceptionMes() {
		return exceptionMessage;
	}

	private ExceptionMessage(String exceptionMesage) {
		this.exceptionMessage = exceptionMesage;
	}
}

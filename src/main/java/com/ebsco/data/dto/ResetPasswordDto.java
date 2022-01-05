package com.ebsco.data.dto;

public class ResetPasswordDto {

  String uuId;
  String newPassword;
  String email;

  public ResetPasswordDto() {
  }

  public String getUuId() {
    return uuId;
  }

  public void setUuId(String uuId) {
    this.uuId = uuId;
  }

  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "ResetPasswordDto{" +
      "uuId='" + uuId + '\'' +
      ", newPassword='" + newPassword + '\'' +
      ", email='" + email + '\'' +
      '}';
  }
}

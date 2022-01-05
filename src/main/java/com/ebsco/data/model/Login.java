package com.ebsco.data.model;

public class Login {

	private String userName;
	private String password;

  public Login(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  public Login() {
  }

  public String getUserName() {
    return this.userName;
  }

  public String getPassword() {
    return this.password;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "Login(userName=" + this.getUserName() + ", password=" + this.getPassword() + ")";
  }
}

package com.ebsco.data.dto;

import com.ebsco.data.entity.Role;
import java.util.List;

public class UsersDTO {

	private Integer userid;

	private String empId;

	private String password;

	private Boolean isActive;

	private String empName;

	private Boolean isTeamHead;

	private String email;

	private String costCenter;

	private List<Role> roles;

  public UsersDTO(Integer userid, String empId, String password, Boolean isActive, String empName,
    Boolean isTeamHead, String email, String costCenter, List<Role> roles) {
    this.userid = userid;
    this.empId = empId;
    this.password = password;
    this.isActive = isActive;
    this.empName = empName;
    this.isTeamHead = isTeamHead;
    this.email = email;
    this.costCenter = costCenter;
    this.roles = roles;
  }

  public UsersDTO() {
  }

  public static UsersDTOBuilder builder() {
    return new UsersDTOBuilder();
  }

  public Integer getUserid() {
    return this.userid;
  }

  public String getEmpId() {
    return this.empId;
  }

  public String getPassword() {
    return this.password;
  }

  public Boolean getIsActive() {
    return this.isActive;
  }

  public String getEmpName() {
    return this.empName;
  }

  public Boolean getIsTeamHead() {
    return this.isTeamHead;
  }

  public String getEmail() {
    return this.email;
  }

  public String getCostCenter() {
    return this.costCenter;
  }

  public List<Role> getRoles() {
    return this.roles;
  }

  public void setUserid(Integer userid) {
    this.userid = userid;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public void setIsTeamHead(Boolean isTeamHead) {
    this.isTeamHead = isTeamHead;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public String toString() {
    return "UsersDTO(userid=" + this.getUserid() + ", empId=" + this.getEmpId() + ", password="
      + this.getPassword() + ", isActive=" + this.getIsActive() + ", empName=" + this.getEmpName()
      + ", isTeamHead=" + this.getIsTeamHead() + ", email=" + this.getEmail() + ", costCenter="
      + this.getCostCenter() + ", roles=" + this.getRoles() + ")";
  }

  public static class UsersDTOBuilder {

    private Integer userid;
    private String empId;
    private String password;
    private Boolean isActive;
    private String empName;
    private Boolean isTeamHead;
    private String email;
    private String costCenter;
    private List<Role> roles;

    UsersDTOBuilder() {
    }

    public UsersDTOBuilder userid(Integer userid) {
      this.userid = userid;
      return this;
    }

    public UsersDTOBuilder empId(String empId) {
      this.empId = empId;
      return this;
    }

    public UsersDTOBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UsersDTOBuilder isActive(Boolean isActive) {
      this.isActive = isActive;
      return this;
    }

    public UsersDTOBuilder empName(String empName) {
      this.empName = empName;
      return this;
    }

    public UsersDTOBuilder isTeamHead(Boolean isTeamHead) {
      this.isTeamHead = isTeamHead;
      return this;
    }

    public UsersDTOBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UsersDTOBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public UsersDTOBuilder roles(List<Role> roles) {
      this.roles = roles;
      return this;
    }

    public UsersDTO build() {
      return new UsersDTO(userid, empId, password, isActive, empName, isTeamHead, email, costCenter,
        roles);
    }

    public String toString() {
      return "UsersDTO.UsersDTOBuilder(userid=" + this.userid + ", empId=" + this.empId
        + ", password=" + this.password + ", isActive=" + this.isActive + ", empName="
        + this.empName + ", isTeamHead=" + this.isTeamHead + ", email=" + this.email
        + ", costCenter=" + this.costCenter + ", roles=" + this.roles + ")";
    }
  }
}

package com.ebsco.data.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "userdetails")
public class UserDetails implements Serializable {

  @Id
  @GeneratedValue(generator = "userIdSeq", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(allocationSize = 1, initialValue = 140, name = "userIdSeq", sequenceName = "userIdsequence")
  private Integer userid;

  @Column(name = "empid")
  private String empId;

  private String password;

  @Column(name = "isactive")
	private Boolean isActive;

	@Column(name = "empname")
	private String empName;

	@Column(name = "isteamhead")
	private Boolean isTeamHead;

	private String email;

	@Column(name = "costcenter")
	private String costCenter;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "userroles", joinColumns = @JoinColumn(name = "UserID"), inverseJoinColumns = @JoinColumn(name = "RoleID"))
	private List<Role> roles;

  public UserDetails(Integer userid, String empId, String password, Boolean isActive,
    String empName, Boolean isTeamHead, String email, String costCenter, List<Role> roles) {
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

  public UserDetails() {
  }

  public static UserDetailsBuilder builder() {
    return new UserDetailsBuilder();
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
    return "UserDetails(userid=" + this.getUserid() + ", empId=" + this.getEmpId() + ", password="
      + this.getPassword() + ", isActive=" + this.getIsActive() + ", empName=" + this.getEmpName()
      + ", isTeamHead=" + this.getIsTeamHead() + ", email=" + this.getEmail() + ", costCenter="
      + this.getCostCenter() + ", roles=" + this.getRoles() + ")";
  }

  public static class UserDetailsBuilder {

    private Integer userid;
    private String empId;
    private String password;
    private Boolean isActive;
    private String empName;
    private Boolean isTeamHead;
    private String email;
    private String costCenter;
    private List<Role> roles;

    UserDetailsBuilder() {
    }

    public UserDetailsBuilder userid(Integer userid) {
      this.userid = userid;
      return this;
    }

    public UserDetailsBuilder empId(String empId) {
      this.empId = empId;
      return this;
    }

    public UserDetailsBuilder password(String password) {
      this.password = password;
      return this;
    }

    public UserDetailsBuilder isActive(Boolean isActive) {
      this.isActive = isActive;
      return this;
    }

    public UserDetailsBuilder empName(String empName) {
      this.empName = empName;
      return this;
    }

    public UserDetailsBuilder isTeamHead(Boolean isTeamHead) {
      this.isTeamHead = isTeamHead;
      return this;
    }

    public UserDetailsBuilder email(String email) {
      this.email = email;
      return this;
    }

    public UserDetailsBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public UserDetailsBuilder roles(List<Role> roles) {
      this.roles = roles;
      return this;
    }

    public UserDetails build() {
      return new UserDetails(userid, empId, password, isActive, empName, isTeamHead, email,
        costCenter, roles);
    }

    public String toString() {
      return "UserDetails.UserDetailsBuilder(userid=" + this.userid + ", empId=" + this.empId
        + ", password=" + this.password + ", isActive=" + this.isActive + ", empName="
        + this.empName + ", isTeamHead=" + this.isTeamHead + ", email=" + this.email
        + ", costCenter=" + this.costCenter + ", roles=" + this.roles + ")";
    }
  }
}

package com.ebsco.data.template;

public class UserSearchTemplate  {

  private String empId;
  private String empName;
  private String emailId;
  private String costCenter;
  private Integer pageNumber;
  private Integer pageSize;


  public UserSearchTemplate(String empId, String empName, String emailId, String costCenter,
    Integer pageNumber, Integer pageSize) {
    this.empId = empId;
    this.empName = empName;
    this.emailId = emailId;
    this.costCenter = costCenter;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public UserSearchTemplate() {
  }

  public static UserSearchTemplateBuilder builder() {
    return new UserSearchTemplateBuilder();
  }

  public String getEmpId() {
    return this.empId;
  }

  public String getEmpName() {
    return this.empName;
  }

  public String getEmailId() {
    return this.emailId;
  }

  public String getCostCenter() {
    return this.costCenter;
  }

  public Integer getPageNumber() {
    return this.pageNumber;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }
  public String toString() {
    return "UserSearchTemplate(empId=" + this.getEmpId() + ", empName=" + this.getEmpName()
      + ", emailId=" + this.getEmailId() + ", costCenter=" + this.getCostCenter()
      + ", pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
  }

  public static class UserSearchTemplateBuilder {

    private String empId;
    private String empName;
    private String emailId;
    private String costCenter;
    private Integer pageNumber;
    private Integer pageSize;

    UserSearchTemplateBuilder() {
    }

    public UserSearchTemplateBuilder empId(String empId) {
      this.empId = empId;
      return this;
    }

    public UserSearchTemplateBuilder empName(String empName) {
      this.empName = empName;
      return this;
    }

    public UserSearchTemplateBuilder emailId(String emailId) {
      this.emailId = emailId;
      return this;
    }

    public UserSearchTemplateBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public UserSearchTemplateBuilder pageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public UserSearchTemplateBuilder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public UserSearchTemplate build() {
      return new UserSearchTemplate(empId, empName, emailId, costCenter, pageNumber, pageSize);
    }

    public String toString() {
      return "UserSearchTemplate.UserSearchTemplateBuilder(empId=" + this.empId + ", empName="
        + this.empName + ", emailId=" + this.emailId + ", costCenter=" + this.costCenter
        + ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ")";
    }
  }
}

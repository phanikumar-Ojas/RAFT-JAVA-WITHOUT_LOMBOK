package com.ebsco.data.template;

public class ReportsSearchTemplate{

  private String status;

  private String priority;

  private String pmId;

  private String userName;

  private String from;

  private String to;

  private String costCenter;

  private Integer pageNumber;

  private Integer pageSize;


  public ReportsSearchTemplate(String status, String priority, String pmId, String userName,
    String from, String to, String costCenter, Integer pageNumber, Integer pageSize) {
    this.status = status;
    this.priority = priority;
    this.pmId = pmId;
    this.userName = userName;
    this.from = from;
    this.to = to;
    this.costCenter = costCenter;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public ReportsSearchTemplate() {
  }

  public String getStatus() {
    return this.status;
  }

  public String getPriority() {
    return this.priority;
  }

  public String getPmId() {
    return this.pmId;
  }

  public String getUserName() {
    return this.userName;
  }

  public String getFrom() {
    return this.from;
  }

  public String getTo() {
    return this.to;
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

  public void setStatus(String status) {
    this.status = status;
  }

  public void setPriority(String priority) {
    this.priority = priority;
  }

  public void setPmId(String pmId) {
    this.pmId = pmId;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
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
    return "ReportsSearchTemplate(status=" + this.getStatus() + ", priority=" + this.getPriority()
      + ", pmId=" + this.getPmId() + ", userName=" + this.getUserName() + ", from="
      + this.getFrom() + ", to=" + this.getTo() + ", costCenter=" + this.getCostCenter()
      + ", pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
  }
}

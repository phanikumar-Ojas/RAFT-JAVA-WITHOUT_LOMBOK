package com.ebsco.data.template;

public class FullFillSearchTemplate {

  private String status;

  private String priority;

  private String pmId;

  private String userName;

  private String from;

  private String to;

  private String ftRetrievedFrom;

  private Integer pageNumber;

  private Integer pageSize;


  public FullFillSearchTemplate(String status, String priority, String pmId, String userName,
    String from, String to, String ftRetrievedFrom, Integer pageNumber, Integer pageSize) {
    this.status = status;
    this.priority = priority;
    this.pmId = pmId;
    this.userName = userName;
    this.from = from;
    this.to = to;
    this.ftRetrievedFrom = ftRetrievedFrom;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public FullFillSearchTemplate() {
  }

  public static FullFillSearchTemplateBuilder builder() {
    return new FullFillSearchTemplateBuilder();
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

  public String getFtRetrievedFrom() {
    return this.ftRetrievedFrom;
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

  public void setFtRetrievedFrom(String ftRetrievedFrom) {
    this.ftRetrievedFrom = ftRetrievedFrom;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String toString() {
    return "FullFillSearchTemplate(status=" + this.getStatus() + ", priority=" + this.getPriority()
      + ", pmId=" + this.getPmId() + ", userName=" + this.getUserName() + ", from="
      + this.getFrom() + ", to=" + this.getTo() + ", ftRetrievedFrom=" + this.getFtRetrievedFrom()
      + ", pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
  }

  public static class FullFillSearchTemplateBuilder {

    private String status;
    private String priority;
    private String pmId;
    private String userName;
    private String from;
    private String to;
    private String ftRetrievedFrom;
    private Integer pageNumber;
    private Integer pageSize;

    FullFillSearchTemplateBuilder() {
    }

    public FullFillSearchTemplateBuilder status(String status) {
      this.status = status;
      return this;
    }

    public FullFillSearchTemplateBuilder priority(String priority) {
      this.priority = priority;
      return this;
    }

    public FullFillSearchTemplateBuilder pmId(String pmId) {
      this.pmId = pmId;
      return this;
    }

    public FullFillSearchTemplateBuilder userName(String userName) {
      this.userName = userName;
      return this;
    }

    public FullFillSearchTemplateBuilder from(String from) {
      this.from = from;
      return this;
    }

    public FullFillSearchTemplateBuilder to(String to) {
      this.to = to;
      return this;
    }

    public FullFillSearchTemplateBuilder ftRetrievedFrom(
      String ftRetrievedFrom) {
      this.ftRetrievedFrom = ftRetrievedFrom;
      return this;
    }

    public FullFillSearchTemplateBuilder pageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public FullFillSearchTemplateBuilder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public FullFillSearchTemplate build() {
      return new FullFillSearchTemplate(status, priority, pmId, userName, from, to, ftRetrievedFrom,
        pageNumber, pageSize);
    }

    public String toString() {
      return "FullFillSearchTemplate.FullFillSearchTemplateBuilder(status=" + this.status
        + ", priority=" + this.priority + ", pmId=" + this.pmId + ", userName=" + this.userName
        + ", from=" + this.from + ", to=" + this.to + ", ftRetrievedFrom=" + this.ftRetrievedFrom
        + ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ")";
    }
  }
}

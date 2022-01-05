package com.ebsco.data.template;

public class FullTextSearchTemplate {

  private String status;

  private String priority;

  private String pmId;

  private String userName;

  private String costCenter;

  private String from;

  private String to;

  private Integer pageNumber;

  private Integer pageSize;

  public FullTextSearchTemplate(String status, String priority, String pmId, String userName,
    String costCenter, String from, String to, Integer pageNumber, Integer pageSize) {
    this.status = status;
    this.priority = priority;
    this.pmId = pmId;
    this.userName = userName;
    this.costCenter = costCenter;
    this.from = from;
    this.to = to;
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public FullTextSearchTemplate() {
  }

  public static FullTextSearchTemplateBuilder builder() {
    return new FullTextSearchTemplateBuilder();
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

  public String getCostCenter() {
    return this.costCenter;
  }

  public String getFrom() {
    return this.from;
  }

  public String getTo() {
    return this.to;
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

  public void setCostCenter(String costCenter) {
    this.costCenter = costCenter;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public String toString() {
    return "FullTextSearchTemplate(status=" + this.getStatus() + ", priority=" + this.getPriority()
      + ", pmId=" + this.getPmId() + ", userName=" + this.getUserName() + ", costCenter="
      + this.getCostCenter() + ", from=" + this.getFrom() + ", to=" + this.getTo()
      + ", pageNumber=" + this.getPageNumber() + ", pageSize=" + this.getPageSize() + ")";
  }

  public static class FullTextSearchTemplateBuilder {

    private String status;
    private String priority;
    private String pmId;
    private String userName;
    private String costCenter;
    private String from;
    private String to;
    private Integer pageNumber;
    private Integer pageSize;

    FullTextSearchTemplateBuilder() {
    }

    public FullTextSearchTemplateBuilder status(String status) {
      this.status = status;
      return this;
    }

    public FullTextSearchTemplateBuilder priority(String priority) {
      this.priority = priority;
      return this;
    }

    public FullTextSearchTemplateBuilder pmId(String pmId) {
      this.pmId = pmId;
      return this;
    }

    public FullTextSearchTemplateBuilder userName(String userName) {
      this.userName = userName;
      return this;
    }

    public FullTextSearchTemplateBuilder costCenter(String costCenter) {
      this.costCenter = costCenter;
      return this;
    }

    public FullTextSearchTemplateBuilder from(String from) {
      this.from = from;
      return this;
    }

    public FullTextSearchTemplateBuilder to(String to) {
      this.to = to;
      return this;
    }

    public FullTextSearchTemplateBuilder pageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public FullTextSearchTemplateBuilder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public FullTextSearchTemplate build() {
      return new FullTextSearchTemplate(status, priority, pmId, userName, costCenter, from, to,
        pageNumber, pageSize);
    }

    public String toString() {
      return "FullTextSearchTemplate.FullTextSearchTemplateBuilder(status=" + this.status
        + ", priority=" + this.priority + ", pmId=" + this.pmId + ", userName=" + this.userName
        + ", costCenter=" + this.costCenter + ", from=" + this.from + ", to=" + this.to
        + ", pageNumber=" + this.pageNumber + ", pageSize=" + this.pageSize + ")";
    }
  }
}

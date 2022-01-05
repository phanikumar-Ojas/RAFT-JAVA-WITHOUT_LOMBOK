package com.ebsco.data.template;

public class RolesSearchTemplate  {
  private Integer pageNumber;

  private Integer pageSize;

  public RolesSearchTemplate() {
  }

  public RolesSearchTemplate(Integer pageNumber, Integer pageSize) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public static RolesSearchTemplateBuilder builder() {
    return new RolesSearchTemplateBuilder();
  }

  public Integer getPageNumber() {
    return this.pageNumber;
  }

  public Integer getPageSize() {
    return this.pageSize;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }


  public String toString() {
    return "RolesSearchTemplate(pageNumber=" + this.getPageNumber() + ", pageSize="
      + this.getPageSize() + ")";
  }

  public static class RolesSearchTemplateBuilder {

    private Integer pageNumber;
    private Integer pageSize;

    RolesSearchTemplateBuilder() {
    }

    public RolesSearchTemplateBuilder pageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public RolesSearchTemplateBuilder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public RolesSearchTemplate build() {
      return new RolesSearchTemplate(pageNumber, pageSize);
    }

    public String toString() {
      return "RolesSearchTemplate.RolesSearchTemplateBuilder(pageNumber=" + this.pageNumber
        + ", pageSize=" + this.pageSize + ")";
    }
  }
}

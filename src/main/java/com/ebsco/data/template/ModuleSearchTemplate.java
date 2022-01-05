package com.ebsco.data.template;

public class ModuleSearchTemplate {
  private Integer pageNumber;

  private Integer pageSize;

  public ModuleSearchTemplate(Integer pageNumber, Integer pageSize) {
    this.pageNumber = pageNumber;
    this.pageSize = pageSize;
  }

  public ModuleSearchTemplate() {
  }

  public static ModuleSearchTemplateBuilder builder() {
    return new ModuleSearchTemplateBuilder();
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
    return "ModuleSearchTemplate(pageNumber=" + this.getPageNumber() + ", pageSize="
      + this.getPageSize() + ")";
  }

  public static class ModuleSearchTemplateBuilder {

    private Integer pageNumber;
    private Integer pageSize;

    ModuleSearchTemplateBuilder() {
    }

    public ModuleSearchTemplateBuilder pageNumber(Integer pageNumber) {
      this.pageNumber = pageNumber;
      return this;
    }

    public ModuleSearchTemplateBuilder pageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public ModuleSearchTemplate build() {
      return new ModuleSearchTemplate(pageNumber, pageSize);
    }

    public String toString() {
      return "ModuleSearchTemplate.ModuleSearchTemplateBuilder(pageNumber=" + this.pageNumber
        + ", pageSize=" + this.pageSize + ")";
    }
  }
}

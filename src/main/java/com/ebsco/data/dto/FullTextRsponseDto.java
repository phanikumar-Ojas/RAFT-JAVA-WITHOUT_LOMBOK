package com.ebsco.data.dto;

import java.util.List;

public class FullTextRsponseDto {

  private List<FullTextRequestDto> fullTextRequestDtoList;

  public FullTextRsponseDto(List<FullTextRequestDto> fullTextRequestDtoList) {
    this.fullTextRequestDtoList = fullTextRequestDtoList;
  }

  public FullTextRsponseDto() {
  }

  public static FullTextRsponseDtoBuilder builder() {
    return new FullTextRsponseDtoBuilder();
  }

  public List<FullTextRequestDto> getFullTextRequestDtoList() {
    return this.fullTextRequestDtoList;
  }

  public void setFullTextRequestDtoList(List<FullTextRequestDto> fullTextRequestDtoList) {
    this.fullTextRequestDtoList = fullTextRequestDtoList;
  }

  public String toString() {
    return "FullTextRsponseDto(fullTextRequestDtoList=" + this.getFullTextRequestDtoList() + ")";
  }

  public static class FullTextRsponseDtoBuilder {

    private List<FullTextRequestDto> fullTextRequestDtoList;

    FullTextRsponseDtoBuilder() {
    }

    public FullTextRsponseDtoBuilder fullTextRequestDtoList(
      List<FullTextRequestDto> fullTextRequestDtoList) {
      this.fullTextRequestDtoList = fullTextRequestDtoList;
      return this;
    }

    public FullTextRsponseDto build() {
      return new FullTextRsponseDto(fullTextRequestDtoList);
    }

    public String toString() {
      return "FullTextRsponseDto.FullTextRsponseDtoBuilder(fullTextRequestDtoList="
        + this.fullTextRequestDtoList + ")";
    }
  }
}

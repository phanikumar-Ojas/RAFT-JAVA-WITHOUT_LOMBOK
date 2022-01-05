package com.ebsco.data.dto;

import java.util.List;

public class FullTextRequestDtoList {

  private List<FullTextRequestDto> fullTextRequestDtoList;

  public FullTextRequestDtoList(List<FullTextRequestDto> fullTextRequestDtoList) {
    this.fullTextRequestDtoList = fullTextRequestDtoList;
  }

  public FullTextRequestDtoList() {
  }

  public List<FullTextRequestDto> getFullTextRequestDtoList() {
    return this.fullTextRequestDtoList;
  }

  public void setFullTextRequestDtoList(List<FullTextRequestDto> fullTextRequestDtoList) {
    this.fullTextRequestDtoList = fullTextRequestDtoList;
  }

  public String toString() {
    return "FullTextRequestDtoList(fullTextRequestDtoList=" + this.getFullTextRequestDtoList()
      + ")";
  }
}

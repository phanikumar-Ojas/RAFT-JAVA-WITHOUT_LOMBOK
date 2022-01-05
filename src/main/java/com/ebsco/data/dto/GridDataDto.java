package com.ebsco.data.dto;

import com.ebsco.data.FileType;

public class GridDataDto {

  private Boolean isFileDownload;
  private FileType fileType;

  public GridDataDto(Boolean isFileDownload, FileType fileType) {
    this.isFileDownload = isFileDownload;
    this.fileType = fileType;
  }

  public GridDataDto() {
  }

  public Boolean getIsFileDownload() {
    return this.isFileDownload;
  }

  public FileType getFileType() {
    return this.fileType;
  }

  public void setIsFileDownload(Boolean isFileDownload) {
    this.isFileDownload = isFileDownload;
  }

  public void setFileType(FileType fileType) {
    this.fileType = fileType;
  }

  public String toString() {
    return "GridDataDto(isFileDownload=" + this.getIsFileDownload() + ", fileType="
      + this.getFileType() + ")";
  }
}

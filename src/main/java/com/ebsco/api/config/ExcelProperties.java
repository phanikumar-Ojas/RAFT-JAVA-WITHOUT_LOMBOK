package com.ebsco.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.file.excel")
public class ExcelProperties {

  @Value("${application.file.excel.format}")
  private String format;
  @Value("${application.file.excel.filename}")
  private String filename;
  @Value("${application.file.excel.sheetname}")
  private String sheetname;

  public String getFormat() {
    return format;
  }

  public void setFormat(String format) {
    this.format = format;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public String getSheetname() {
    return sheetname;
  }

  public void setSheetname(String sheetname) {
    this.sheetname = sheetname;
  }

  public ExcelProperties() {
  }

  public ExcelProperties(String format, String filename, String sheetname) {
    this.format = format;
    this.filename = filename;
    this.sheetname = sheetname;
  }

  @Override
  public String toString() {
    return "ExcelProperties{" +
      "format='" + format + '\'' +
      ", filename='" + filename + '\'' +
      ", sheetname='" + sheetname + '\'' +
      '}';
  }
}

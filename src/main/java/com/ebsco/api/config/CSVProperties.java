package com.ebsco.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.file.csv")
public class CSVProperties {

  private String format;
  private String filename;

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

  public CSVProperties() {
  }

  public CSVProperties(String format, String filename) {
    this.format = format;
    this.filename = filename;
  }

  @Override
  public String toString() {
    return "CSVProperties{" +
      "format='" + format + '\'' +
      ", filename='" + filename + '\'' +
      '}';
  }
}

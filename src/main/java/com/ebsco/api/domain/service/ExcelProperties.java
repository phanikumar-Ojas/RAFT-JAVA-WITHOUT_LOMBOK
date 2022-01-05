package com.ebsco.api.domain.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("application.file.excel")
@Data
public class ExcelProperties {

  @Value("${application.file.excel.format}")
  private String format;
  @Value("${application.file.excel.filename}")
  private String filename;
  @Value("${application.file.excel.sheetname}")
  private String sheetname;


}

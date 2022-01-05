package com.ebsco.api.domain.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "application.file.csv")
@Data
public class CSVProperties {

  private String format;
  private String filename;
}

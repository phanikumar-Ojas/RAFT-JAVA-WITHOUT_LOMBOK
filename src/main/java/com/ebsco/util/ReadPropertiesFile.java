package com.ebsco.util;

import com.ebsco.data.dto.EmailDetails;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {

  public static EmailDetails readConfig() {
    EmailDetails emailEntity = new EmailDetails();
    System.out.println("setReadConfig");

    Properties properties = new Properties();
    try {
      properties.load(
        ReadPropertiesFile.class.getClassLoader().getResourceAsStream("mail.properties"));
      emailEntity.setFrom((String) properties.get("setFrom"));
      emailEntity.setPassword((String) properties.get("setPassword"));

    } catch (IOException e) {
      e.printStackTrace();
    }
    return emailEntity;
  }

}

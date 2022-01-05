package com.ebsco.util;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileUtils {

  public static String convertInstantToString(Instant instant) {
    if (instant == null) {
      return null;
    }
    DateTimeFormatter instantConvertor = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
      .withZone(ZoneId.systemDefault());
    return instantConvertor.format(instant);

  }

  public static String returnNullIfNoValuePresentAndReplaceColonWithEmpty(Object object) {
    String present = returnNullIfNoValuePresent(object);
    return present != null ? present.replace(" ,", "").replace("  ,", "").replace("   ,", "")
      .replace("    ,", "").replace(",", "") : "";
  }

  public static String returnNullIfNoValuePresent(Object object) {
    if (object == null) {
      return "";
    }
    return String.valueOf(object);
  }


}

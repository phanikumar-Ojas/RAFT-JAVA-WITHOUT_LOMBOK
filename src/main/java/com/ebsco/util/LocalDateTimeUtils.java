package com.ebsco.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeUtils {

  public static String differenceWithCurrentTime(LocalDateTime localDateTime) {
    checkNotNull(localDateTime, "localDateTime required but found null");
    return String.valueOf(ChronoUnit.MINUTES.between(localDateTime, LocalDateTime.now()));
  }

}

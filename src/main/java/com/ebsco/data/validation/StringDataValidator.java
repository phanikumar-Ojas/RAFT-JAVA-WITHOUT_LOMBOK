package com.ebsco.data.validation;

import com.ebsco.data.exception.URLValidationException;
import com.google.common.base.Strings;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class StringDataValidator {

  public static boolean validateString(String data) {
    if (!Strings.isNullOrEmpty(data) && StringUtils
      .isNotBlank(data)) {
      return true;
    }
    return false;
  }

  public static void validateStringData(String url) {
    if (Objects.isNull(url)) {
      throw new URLValidationException("url must be required but found null");
    }
    if (StringUtils.isEmpty(url)) {
      throw new URLValidationException("url must be required but found empty");
    }
    if (StringUtils.isBlank(url)) {
      throw new URLValidationException("url must be required but found blank");
    }

  }


}

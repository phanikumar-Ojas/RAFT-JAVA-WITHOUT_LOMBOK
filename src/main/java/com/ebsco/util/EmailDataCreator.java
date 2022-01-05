package com.ebsco.util;

import static com.ebsco.constants.EbescoConstants.MAIL_PASSWORD_EXPIRY;
import static com.ebsco.constants.EbescoConstants.MAIL_SUBJECT_RAFT_RESET_PASSWORD;

import com.ebsco.data.dto.EmailDetails;
import com.ebsco.data.entity.UserDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmailDataCreator {

  private static final Logger log= LoggerFactory.getLogger(EmailDataCreator.class);

  public static EmailDetails createEmailDetails(UserDetails userDetails, String generatedUUID,
    String url) {
    log.debug("creating EmailDetails");
    return EmailDetails.builder().email(userDetails.getEmail()).to(userDetails.getEmail())
      .message(createMessage(userDetails.getEmpId(), generatedUUID, url))
      .subject(MAIL_SUBJECT_RAFT_RESET_PASSWORD)
      .build();

  }

  public static String createMessage(String userName, String generatedUUID, String url) {
    return "Hi " + userName + ", please reset your password by clicking:" + createUrl(url,
      generatedUUID) + "\n" + expiryQuote();
  }

  private static String createUrl(String url, String generatedUUID) {
    return "<a href="+url + "/" + generatedUUID+">click here </a>";
  }

  private static String expiryQuote() {
    return MAIL_PASSWORD_EXPIRY;
  }

}

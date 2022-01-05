package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.service.EmailService;
import com.ebsco.data.dto.EmailDetails;
import com.ebsco.util.ReadPropertiesFile;
import com.ebsco.data.validation.DtoValidationUtils;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("v1EmailServiceImpl")
@Slf4j
public class V1EmailServiceImpll implements EmailService {

  private static MimeMessage mimeMessage = null;

  static {
    Properties props = new Properties();
    EmailDetails entity1 = ReadPropertiesFile.readConfig();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp.office365.com");
    props.put("mail.smtp.port", "587");
    Session session = Session.getInstance(props, new Authenticator() {
      @Override
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(entity1.getFrom(), entity1.getPassword());
      }

    });
    mimeMessage = new MimeMessage(session);
    try {
      mimeMessage.setFrom(new InternetAddress(entity1.getFrom()));
    } catch (Exception e) {
      log.error(e.getMessage());

    }


  }

  @Override
  public void sendEmail(EmailDetails emailDetails) throws Exception {

    DtoValidationUtils.validateEmail(emailDetails);

    mimeMessage.addRecipients(RecipientType.TO, emailDetails.getTo());
    mimeMessage.setContent(emailDetails.getMessage(), "text/html");
    mimeMessage.setSubject(emailDetails.getSubject());
    Transport.send(mimeMessage);

  }

}





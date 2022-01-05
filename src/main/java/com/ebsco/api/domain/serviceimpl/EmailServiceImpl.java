//package com.ebsco.serviceimpl;
//
//import com.ebsco.dto.EmailDetails;
//import com.ebsco.service.EmailService;
//import javax.mail.Message;
//import javax.mail.Message.RecipientType;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.mail.javamail.JavaMailSender;
//import org.springframework.stereotype.Service;
//
//@Service("emailServiceImpl")
//@Slf4j
//public class EmailServiceImpl implements EmailService {
//
//  @Autowired
//  JavaMailSender javaMailSender;
//
//  @Override
//  public void sendEmail(EmailDetails emailDetails) {
//    Message mimeMessage = javaMailSender.createMimeMessage();
//    try {
//      mimeMessage.setContent(emailDetails.getMessage(), "text/html; charset=utf-8");
//
//      mimeMessage.setFrom(new InternetAddress(emailDetails.getFrom()));
//      mimeMessage.setRecipients(RecipientType.TO, InternetAddress.parse(emailDetails.getTo()));
//      mimeMessage.setSubject(emailDetails.getSubject());
//      Transport.send(mimeMessage);
//    } catch (Exception exception) {
//      log.error(exception.getMessage());
//    }
//  }
//}

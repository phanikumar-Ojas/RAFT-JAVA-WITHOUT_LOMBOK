package com.ebsco.data.dto;

public class EmailDetails {

  private String from;
  private String to;
  private String bcc;
  private String cc;
  private String message;
  private String subject;
  private String email;
  private String password;

  public EmailDetails(String from, String to, String bcc, String cc, String message, String subject,
    String email, String password) {
    this.from = from;
    this.to = to;
    this.bcc = bcc;
    this.cc = cc;
    this.message = message;
    this.subject = subject;
    this.email = email;
    this.password = password;
  }

  public EmailDetails() {
  }

  public static EmailDetailsBuilder builder() {
    return new EmailDetailsBuilder();
  }

  public String getFrom() {
    return this.from;
  }

  public String getTo() {
    return this.to;
  }

  public String getBcc() {
    return this.bcc;
  }

  public String getCc() {
    return this.cc;
  }

  public String getMessage() {
    return this.message;
  }

  public String getSubject() {
    return this.subject;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public void setFrom(String from) {
    this.from = from;
  }

  public void setTo(String to) {
    this.to = to;
  }

  public void setBcc(String bcc) {
    this.bcc = bcc;
  }

  public void setCc(String cc) {
    this.cc = cc;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String toString() {
    return "EmailDetails(from=" + this.getFrom() + ", to=" + this.getTo() + ", bcc=" + this.getBcc()
      + ", cc=" + this.getCc() + ", message=" + this.getMessage() + ", subject="
      + this.getSubject() + ", email=" + this.getEmail() + ", password=" + this.getPassword()
      + ")";
  }

  public static class EmailDetailsBuilder {

    private String from;
    private String to;
    private String bcc;
    private String cc;
    private String message;
    private String subject;
    private String email;
    private String password;

    EmailDetailsBuilder() {
    }

    public EmailDetailsBuilder from(String from) {
      this.from = from;
      return this;
    }

    public EmailDetailsBuilder to(String to) {
      this.to = to;
      return this;
    }

    public EmailDetailsBuilder bcc(String bcc) {
      this.bcc = bcc;
      return this;
    }

    public EmailDetailsBuilder cc(String cc) {
      this.cc = cc;
      return this;
    }

    public EmailDetailsBuilder message(String message) {
      this.message = message;
      return this;
    }

    public EmailDetailsBuilder subject(String subject) {
      this.subject = subject;
      return this;
    }

    public EmailDetailsBuilder email(String email) {
      this.email = email;
      return this;
    }

    public EmailDetailsBuilder password(String password) {
      this.password = password;
      return this;
    }

    public EmailDetails build() {
      return new EmailDetails(from, to, bcc, cc, message, subject, email, password);
    }

    public String toString() {
      return "EmailDetails.EmailDetailsBuilder(from=" + this.from + ", to=" + this.to + ", bcc="
        + this.bcc + ", cc=" + this.cc + ", message=" + this.message + ", subject=" + this.subject
        + ", email=" + this.email + ", password=" + this.password + ")";
    }
  }
}

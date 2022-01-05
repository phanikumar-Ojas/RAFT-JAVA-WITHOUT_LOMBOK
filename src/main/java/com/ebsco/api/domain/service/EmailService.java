package com.ebsco.api.domain.service;

import com.ebsco.data.dto.EmailDetails;

public interface EmailService {
   void sendEmail(EmailDetails emailDetails) throws Exception;

}

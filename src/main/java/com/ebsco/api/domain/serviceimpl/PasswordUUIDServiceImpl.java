package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.repository.PasswordUUIDRepository;
import com.ebsco.api.domain.service.PasswordUUIDService;
import com.ebsco.data.entity.PasswordUUIDDetails;
import java.time.LocalDateTime;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasswordUUIDServiceImpl implements PasswordUUIDService {
  private static final Logger log= LoggerFactory.getLogger(PasswordUUIDServiceImpl.class);

  @Autowired
  PasswordUUIDRepository passwordUUIDRepository;

  @Override
  public String storeUserDetails(String userName, Integer id,String email) {
    log.info(String.format("storing the details for the user: %s", userName));
// '140', 'Phani', 'kumar', '1', 'Phani Kumar', NULL, 'phanikumarlukky13@gmail.com', 'DynaMed Editorial'
    PasswordUUIDDetails passwordUUIDDetails = PasswordUUIDDetails.builder()
      .userId(id)
      .userName(userName)
      .email(email)
      .id(new Random().nextInt(600000))
      .createdTime(LocalDateTime.now())
      .build();
    PasswordUUIDDetails uuidDetails = passwordUUIDRepository.save(passwordUUIDDetails);

    return String.valueOf(uuidDetails.getId());
  }

  @Override
  public PasswordUUIDDetails getUserDetails(String uuId) {
    return passwordUUIDRepository.findByUUID(uuId);
  }

  @Override
  public String getEmailById(String id) {

    return passwordUUIDRepository.findEmailByID(id);


  }


}

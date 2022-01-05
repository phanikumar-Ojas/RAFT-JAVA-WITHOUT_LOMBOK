package com.ebsco.api.domain.service;

import com.ebsco.data.entity.PasswordUUIDDetails;
import javax.validation.constraints.NotNull;

public interface PasswordUUIDService {

  String storeUserDetails(String userName, Integer id,String email);

  PasswordUUIDDetails getUserDetails(@NotNull String uuId);

   String getEmailById(String id);


}

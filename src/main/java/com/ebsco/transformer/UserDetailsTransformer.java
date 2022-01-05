package com.ebsco.transformer;

import com.ebsco.data.dto.UsersDTO;
import com.ebsco.data.entity.UserDetails;
import com.ebsco.data.exception.UserDetailsNotFoundException;

public class UserDetailsTransformer {

	public static UserDetails fromDtoToUser(UsersDTO dto) {
		if (dto == null)
			throw new UserDetailsNotFoundException("The User Details not found");

		return UserDetails.builder().costCenter(dto.getCostCenter()).email(dto.getEmail()).empId(dto.getEmpId())
				.empName(dto.getEmpName()).isActive(dto.getIsActive()).isTeamHead(dto.getIsTeamHead())
				.password(dto.getPassword()).roles(dto.getRoles()).userid(dto.getUserid()).build();
	}

	public static UsersDTO fromEntityToDto(UserDetails details) {
		if (details == null)
			throw new UserDetailsNotFoundException("The User Details not found");

		return UsersDTO.builder().costCenter(details.getCostCenter()).email(details.getEmail())
				.empId(details.getEmpId()).empName(details.getEmpName()).isActive(details.getIsActive())
				.isTeamHead(details.getIsTeamHead()).password(details.getPassword()).roles(details.getRoles())
				.userid(details.getUserid()).build();

	}
}

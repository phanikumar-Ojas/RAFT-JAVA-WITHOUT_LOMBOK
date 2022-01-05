package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.repository.RolesRepository;
import com.ebsco.data.dto.RoleDTO;
import com.ebsco.transformer.RolesTransformer;
import java.util.List;

import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Role;
import com.ebsco.api.domain.service.RolesService;
import com.ebsco.util.PaginationUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesRepository rolesRepository;

	@Override
	public Response findAll(Integer pageSize, Integer pageNumber) {

		Integer resultPageSize = PaginationUtils.getPageSize(pageSize, pageNumber);
		List<Role> findAll ;
		Response response = Response.builder().build();
		try {
			findAll = rolesRepository.findAllRoles(resultPageSize, pageSize);
			Integer totalRecords = rolesRepository.getRolesCount();

			Integer toalPages = PaginationUtils.getTotalPages(totalRecords, pageSize);
      List<RoleDTO> roleDTOS = findAll.stream().map(RolesTransformer::fromEntityToDTO)
        .collect(Collectors.toList());
      response = Response.builder().result(roleDTOS).totalPages(toalPages).totalRecords(totalRecords)
					.status(ExceptionMessage.OK).build();

		} catch (RuntimeException e) {
			e.printStackTrace();
			response.setErrorMessage(e.getMessage());
			response.setErrorCode("500");

		}
		return response;
	}

	@Override
	public Response save(@NotNull Role role) {

		Response response = Response.builder().build();
		try {
			Role savedUser = rolesRepository.save(role);
			response.setResult(savedUser);
			response.setHttpStatus(HttpStatus.CREATED);
			response.setStatus(ExceptionMessage.Created);

		} catch (Exception e) {
			response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
			response.setStatus(ExceptionMessage.Exception);
			response.setErrorMessage(e.getMessage());

		}

		return response;

	}

	@Override
	public Role findById(String roleId) {
		log.debug("finding the role for the id %d", roleId);
		return rolesRepository.findById(Integer.valueOf(roleId)).orElse(null);
	}

}

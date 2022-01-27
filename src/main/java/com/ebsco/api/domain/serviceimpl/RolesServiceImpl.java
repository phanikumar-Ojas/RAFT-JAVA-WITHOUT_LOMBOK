package com.ebsco.api.domain.serviceimpl;

import static com.google.common.base.Preconditions.checkArgument;

import com.ebsco.api.domain.repository.RolesRepository;
import com.ebsco.api.domain.service.RolesService;
import com.ebsco.data.dto.ExceptionMessage;
import com.ebsco.data.dto.Response;
import com.ebsco.data.dto.RoleDTO;
import com.ebsco.data.entity.Role;
import com.ebsco.transformer.RolesTransformer;
import com.ebsco.util.PaginationUtils;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {

  private static final Logger log = LoggerFactory.getLogger(RolesServiceImpl.class);

  @Autowired
  private RolesRepository rolesRepository;

  @Override
  public Response findAll(Integer pageSize, Integer pageNumber) {

    Integer resultPageSize = PaginationUtils.getPageSize(pageSize, pageNumber);
    List<Role> findAll;
    Response response = Response.builder().build();
    try {
      findAll = rolesRepository.findAllRoles(resultPageSize, pageSize);
      Integer totalRecords = rolesRepository.getRolesCount();

      Integer toalPages = PaginationUtils.getTotalPages(totalRecords, pageSize);
      List<RoleDTO> roleDTOS = findAll.stream().map(RolesTransformer::fromEntityToDTO)
        .collect(Collectors.toList());
      response = Response.builder().result(roleDTOS).totalPages(toalPages)
        .totalRecords(totalRecords)
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

  @Override
  public void deleteRoleById(Integer roleId) {
    checkArgument(roleId != null && roleId > 0, "roleId must be a valid number");
    Optional<Role> byId = rolesRepository.findById(roleId);
    if (byId.isPresent()) {
      rolesRepository.deleteById(roleId);
    }
  }

  @Override
  public List<Role> getAllRoles() {
    return rolesRepository.findAll();
  }

}

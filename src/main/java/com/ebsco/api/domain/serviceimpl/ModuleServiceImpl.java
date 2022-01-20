package com.ebsco.api.domain.serviceimpl;

import com.ebsco.api.domain.repository.ModuleRepository;
import com.ebsco.api.domain.service.ModuleService;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Module;
import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.transformer.ModuleTransformer;
import com.ebsco.util.PaginationUtils;
import com.ebsco.data.validation.DtoValidationUtils;
import com.ebsco.data.validation.DtoValidationUtils.Optionality;

@Service(value = "v1ModuleServiceImpl")
public class ModuleServiceImpl implements ModuleService {

  @Autowired
  private ModuleRepository moduleRepository;

  @Override
  public Response getAllModules(@NotNull Integer pageSize, @NotNull Integer pageNumber) {
    Integer resultPageSize = PaginationUtils.getPageSize(pageSize, pageNumber);
    Response response = Response.builder().build();

    try {
      List<Module> allModules = moduleRepository.getAllModules(resultPageSize, pageSize);
      int totalRecords = moduleRepository.getmoduleCount();

      Integer toalPages = PaginationUtils.getTotalPages(totalRecords, pageSize);

      response.setResult(allModules);
      response.setHttpStatus(HttpStatus.OK);
      response.setRes("list retrieved successfully");
      response.setTotalPages(toalPages);
      response.setTotalRecords(totalRecords);
    } catch (Exception e) {
      response.setHttpStatus(HttpStatus.BAD_REQUEST);
      response.setErrorMessage(e.getMessage());
    }
    return response;
  }

  @Override
  public Module saveModule(ModuleDTO module) {
    if (Objects.isNull(module)) {
      throw new DataNotFoundException(
        "The Data which is used to create module is require but found null");
    }
    Module fromDTOToEntity = ModuleTransformer.fromDTOToEntity(module);
    return moduleRepository.save(fromDTOToEntity);
  }

  @Override
  public Module getModuleById(@NotNull Integer moduleId) {
    return moduleRepository.findById(moduleId).orElse(null);
  }

  @Override
  public void deleteModuleById(@NotNull Integer moduleId) {

    DtoValidationUtils.validate(moduleId, Optionality.REQUIRED);
    if (getModuleById(moduleId) != null) {
      moduleRepository.deleteById(moduleId);
    }

  }

  @Override
  public List<Module> getModulesByParentIds(@Valid List<Integer> parentIds) {
    return moduleRepository.findNodulesByParentId(parentIds);
  }

  @Override
  public List<Module> getAllModules() {
    return moduleRepository.findAll();
  }

}

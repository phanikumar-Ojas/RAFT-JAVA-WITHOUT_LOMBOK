package com.ebsco.api.domain.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.ebsco.api.domain.service.ModuleService;
import com.ebsco.data.dto.ModuleDTO;
import com.ebsco.data.template.ModuleSearchTemplate;
import com.ebsco.data.dto.Response;
import com.ebsco.data.entity.Module;
import com.ebsco.data.exception.DataNotFoundException;
import com.ebsco.data.exception.DataValidationException;
import com.ebsco.data.exception.ModuleDataNotFoundException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ModuleControllerTest {

  Module module;
  Module module1;
  @InjectMocks
  private ModuleController moduleController;
  @Mock
  private ModuleService moduleService;

//  @Mock
//  RabbitMQSender rabbitMQSender;

  @BeforeEach
  public void before() {
    MockitoAnnotations.openMocks(this);
    module = new Module();
    module1 = new Module(1, "aaa", module, "path", "icon", "imagepath", 123, true);

  }

  @Test
  public void test_saveModule_happyPath() {

    Response response = new Response();
    response.setHttpStatus(HttpStatus.CREATED);
    response.setRes("The Module is successfully created or Updated");
    response.setResult(getModuleDto());

    when(moduleService.saveModule(ArgumentMatchers.any())).thenReturn(module1);
    ResponseEntity<Object> saveModule = moduleController.saveModule(getModuleDto());
    Response actualResponse = (Response) saveModule.getBody();
    assertNotNull(actualResponse);
    assertEquals(response.getResult(), actualResponse.getResult());
    assertEquals(response.getHttpStatus(), HttpStatus.CREATED);
  }

  @Test
  public void test_saveModule_withoutModuleName_ShouldThrowDataValidationException() {

    ModuleDTO dto = ModuleDTO.builder().build();
    assertThrows(DataValidationException.class, () -> moduleController.saveModule(dto));

  }

  @Test
  public void test_saveModule_WithNullModuleDto_ShouldThrowDataNotFoundException() {

    assertThrows(DataNotFoundException.class, () -> moduleController.saveModule(null));

  }

  @Test
  public void test_saveModule_withException() {

    when(moduleService.saveModule(any())).thenReturn(null);
    assertThrows(DataNotFoundException.class, () -> moduleController.saveModule(null));

  }

  @Test
  public void test_moduleDataSearch_withValidSearchTemplate_shouldReturnExceptedData() {

    ModuleSearchTemplate searchTemplate = ModuleSearchTemplate.builder().pageNumber(1).pageSize(5).build();

    List<Module> listOfModules = getListOfModulesBasedOnSize(searchTemplate.getPageSize());

    Response response = Response.builder().result(listOfModules).httpStatus(HttpStatus.OK)
        .res("list retrieved successfully").totalPages(1).totalRecords(5).build();

    when(moduleService.getAllModules(searchTemplate.getPageSize(), searchTemplate.getPageNumber()))
        .thenReturn(response);
    ResponseEntity<Object> moduleDataSearch = moduleController.moduleDataSearch(searchTemplate);
    Response actualResponse = (Response) moduleDataSearch.getBody();

    List<Module> moduleList = (List<Module>) response.getResult();

    assertNotNull(actualResponse);
    assertEquals(listOfModules, moduleList);
    assertEquals(listOfModules.size(), moduleList.size());
    assertEquals(response.getRes(), actualResponse.getRes());
    assertEquals(response.getHttpStatus(), actualResponse.getHttpStatus());
    assertEquals(response.getTotalPages(), actualResponse.getTotalPages());
    assertEquals(response.getTotalRecords(), actualResponse.getTotalRecords());

  }

  @Test
  public void test_moduleDataSearch_withSearchTemplateNull_ShouldThrowDataNotFoundException() {
    DataValidationException exception = assertThrows(DataValidationException.class,
        () -> moduleController.moduleDataSearch(null));

    assertEquals(exception.getMessage(), "The Required value is not found");

  }


  @Test
  public void test_moduleDataSearch_withSearchTemplateWithNullPageNumber_ShouldThrowDataValidationException() {
    ModuleSearchTemplate searchTemplate = ModuleSearchTemplate.builder().pageSize(2).build();
    DataValidationException exception = assertThrows(DataValidationException.class,
        () -> moduleController.moduleDataSearch(searchTemplate));

    assertEquals(exception.getMessage(), "The PageNumber Value is required but found null");

  }

  @Test
  public void test_moduleDataSearch_withSearchTemplateWithNullPageSize_ShouldThrowDataValidationException() {
    ModuleSearchTemplate searchTemplate = ModuleSearchTemplate.builder().pageNumber(1).build();
    DataValidationException exception = assertThrows(DataValidationException.class,
        () -> moduleController.moduleDataSearch(searchTemplate));

    assertEquals(exception.getMessage(), "The PageSize Value is required but found null");

  }


  @Test
  public void test_moduleDataSearch_withValidSearchTemplateAndWithNullResultInResponse_shouldThrowModuleDataNotFoundException() {
    Response response = Response.builder().build();
    ModuleSearchTemplate searchTemplate = ModuleSearchTemplate.builder().pageNumber(1).pageSize(5).build();
    when(moduleService.getAllModules(searchTemplate.getPageSize(), searchTemplate.getPageNumber()))
        .thenReturn(response);
    assertThrows(ModuleDataNotFoundException.class,
        () -> moduleController.moduleDataSearch(searchTemplate));

  }

  public ModuleDTO getModuleDto() {
    return ModuleDTO.builder()
				.moduleId(1)
				.moduleName("aaa")
				.parentId(module)
				.modulePath("path")
        .iconName("icon")
        .imagePath("imagepath")
				.orderNumber(123)
				.openInChildWindow(true)
				.build();

  }

  public List<Module> getListOfModulesBasedOnSize(int size) {
    List<Module> modules = new ArrayList<Module>();
    for (int i = 0; i < size; i++) {
      modules.add(Module.builder().iconName("iconName" + (i + 1)).moduleId(i + 1)
          .moduleName("moduleName" + (i + 1)).build());
    }

    return modules;

  }

}

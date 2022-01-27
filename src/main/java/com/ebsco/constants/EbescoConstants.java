package com.ebsco.constants;

import com.ebsco.data.dto.FullTextRequestDto;
import com.google.common.collect.Lists;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public interface EbescoConstants {

  // Urls which can are using in the classes

  String EBESCOHOSTPREFIX = "http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=";
  String EBESCOHOSTSUFFIX = "&site=ehost-live";
  String NCBI = "https://www.ncbi.nlm.nih.gov/pmc/articles/";
  String EHOST_LINK_URL_START = "http://search.ebscohost.com/login.aspx?authtype=uid&user=dmeditors&password=medicine19!&direct=true&db=mdc&AN=";
  String PUBMED_FT_URL = "https://pubmed.ncbi.nlm.nih.gov/";
  String EHOST_SEARCH_LINK = "https://web.b.ebscohost.com/";

  // Normal Data which will use in al the classes
  String PMID_FREE_ARTICLE_INSTRUCTIONS_PDF_DOWNLOAD = "Free article, please download and attach PDF";

  // Custom sperators

  String DATA_COMMASEPERATOR = ",";
  String DATA_COLONSEPERATOR = ":";
  String MAIL_SUBJECT_RAFT_RESET_PASSWORD = "Reset Password for RAFT Application";
  String MAIL_PASSWORD_EXPIRY = "<h3 style=color:red>Link expires in 30 Minutes</h3>";

  // FulllTextRequest Status Messages
  String CANCELED_REQUEST = "Cancelled Request";
  String NOT_REQUIRED = "Not Required";
  String IN_PROGRESS = "In Progress";

  // Module Fetching constants.
  String MODULE_PARENT="parent";
  String MODULE_CHILD="child";

  // for checking eHostFtLink
  String PDF_FULL_TEXT = "PDF Full Text";

  //status messages
  String OPEN_FREE_FULL_TEXT = "Open Free Full Text";
  String REQUEST_FULL_TEXT = "Request Full Text";

  String WINDOW_LOCATION_REPLACE = "window.location.replace";
  List<String> FIELDS_LIST = getFeildsList();


  static List<String> getFeildsList() {
    List<String> fieldsList = new ArrayList<>();
    Field[] fields = FullTextRequestDto.class.getDeclaredFields();
    for (Field field : fields) {
      fieldsList.add(field.getName());
    }

    return fieldsList;
  }


}

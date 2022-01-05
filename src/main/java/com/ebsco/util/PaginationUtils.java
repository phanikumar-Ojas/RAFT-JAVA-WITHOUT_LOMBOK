package com.ebsco.util;


public class PaginationUtils {


	public static Integer getPageSize(Integer pageSize, Integer pageNumber) {
    Integer resultantPageSize = 0;
    if (pageNumber != null && pageSize != null) {
      if (!pageNumber.equals(1)) {
        resultantPageSize = Math.multiplyExact(pageNumber - 1, pageSize);
      }
    }
    return resultantPageSize;
  }



	public static Integer getTotalPages(Integer totalRecords, Integer pageSize) {
    Integer totalPages = 1;
    if (pageSize != null) {
      if (!(totalRecords == 0 || totalRecords <= pageSize)) {
        int totalPagesCount = totalRecords / pageSize;
        totalPages = (totalRecords % pageSize == 0) ? totalPagesCount : totalPagesCount + 1;
      }
    }
    return totalPages;

  }
}

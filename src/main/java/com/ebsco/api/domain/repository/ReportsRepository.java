package com.ebsco.api.domain.repository;

import com.ebsco.data.entity.FullTextRequest;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportsRepository extends JpaRepository<FullTextRequest, Integer> {

  @Query(value = "select * from fulltextrequestinfo ORDER BY creationDate DESC limit 1000 ", nativeQuery = true)
  List<FullTextRequest> findReportsGridData();

  @Query(value = "select * from fulltextrequestinfo where "
    + " CASE WHEN :status IS NOT NULL THEN status= :status ELSE status LIKE '%' OR status IS NULL END"
    + " AND CASE WHEN :priority IS NOT NULL THEN priority= :priority ELSE priority LIKE '%' OR priority IS NULL END"
    + " AND CASE WHEN :pmId IS NOT NULL THEN pmId= :pmId ELSE pmId LIKE '%' OR pmId IS NULL END"
    + " AND CASE WHEN :costCenter IS NOT NULL THEN costCenter= :costCenter ELSE costCenter LIKE '%' OR costCenter IS NULL END"
    + " AND CASE WHEN :from IS NOT NULL THEN creationdate between  :from and :to ELSE creationdate LIKE '%' OR creationdate IS NULL END"
    + " AND CASE WHEN :requestedBy IS NOT NULL THEN RequestedBy= :requestedBy ELSE RequestedBy LIKE '%' OR RequestedBy IS NULL END"
    + " AND IsRequested IS TRUE  ORDER BY creationDate DESC ", nativeQuery = true)
  List<FullTextRequest> searchBasedOnReportsSearchTemplate(@Param("status") String status,
    @Param("priority") String priority,
    @Param("pmId") String pmId, @Param("costCenter") String costCenter,
    @Param("from") String from, @Param("to") String to, @Param("requestedBy") String requestedBy);

  @Query(value = "select * from fulltextrequestinfo where "
    + " CASE WHEN :status IS NOT NULL THEN status= :status ELSE status LIKE '%' OR status IS NULL END"
    + " AND CASE WHEN :priority IS NOT NULL THEN priority= :priority ELSE priority LIKE '%' OR priority IS NULL END"
    + " AND CASE WHEN :pmId IS NOT NULL THEN pmId= :pmId ELSE pmId LIKE '%' OR pmId IS NULL END"
    + " AND CASE WHEN :costCenter IS NOT NULL THEN costCenter= :costCenter ELSE costCenter LIKE '%' OR costCenter IS NULL END"
    + " AND CASE WHEN :from IS NOT NULL THEN creationdate between  :from and :to ELSE creationdate LIKE '%' OR creationdate IS NULL END"
    + " AND CASE WHEN :requestedBy IS NOT NULL THEN RequestedBy= :requestedBy ELSE  RequestedBy LIKE '%' OR RequestedBy IS NULL END"
    + " AND IsRequested IS TRUE  ORDER BY creationDate DESC limit :pageNumber , :pageSize ", nativeQuery = true)
  List<FullTextRequest> searchBasedOnReportsSearchTemplateWithPagination(
    @Param("status") String status,
    @Param("priority") String priority,
    @Param("pmId") String pmId, @Param("costCenter") String costCenter,
    @Param("from") String from, @Param("to") String to, @Param("requestedBy") String requestedBy,
    @Param("pageNumber") Integer pageNumber, @Param("pageSize") Integer pageSize);

  @Query(value = "select count(*) from fulltextrequestinfo where "
    + " CASE WHEN :status IS NOT NULL THEN status= :status ELSE status LIKE '%' OR status IS NULL END"
    + " AND CASE WHEN :priority IS NOT NULL THEN priority= :priority ELSE priority LIKE '%' OR priority IS NULL END"
    + " AND CASE WHEN :pmId IS NOT NULL THEN pmId= :pmId ELSE pmId LIKE '%' OR pmId IS NULL END"
    + " AND CASE WHEN :costCenter IS NOT NULL THEN costCenter= :costCenter ELSE costCenter LIKE '%' OR costCenter IS NULL END"
    + " AND CASE WHEN :from IS NOT NULL THEN creationdate between  :from and :to ELSE creationdate LIKE '%' OR creationdate IS NULL END"
    + " AND CASE WHEN :requestedBy IS NOT NULL THEN RequestedBy= :requestedBy ELSE RequestedBy LIKE '%' OR  RequestedBy IS NULL END"
    + " AND IsRequested IS TRUE ", nativeQuery = true)
  int getCountBasedOnPerportsSearchTemplate(@Param("status") String status,
    @Param("priority") String priority,
    @Param("pmId") String pmId, @Param("costCenter") String costCenter,
    @Param("from") String from, @Param("to") String to, @Param("requestedBy") String requestedBy);


}

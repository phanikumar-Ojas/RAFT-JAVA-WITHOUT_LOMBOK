package com.ebsco.api.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ebsco.data.entity.FullTextRequest;
import org.springframework.data.repository.query.Param;

public interface FullTextRepository extends JpaRepository<FullTextRequest, Integer> {
  @Query(value = "select count(pmid) from fulltextrequestinfo where pmid=?1",nativeQuery = true)
  int getPmIdCount(Integer pmId);

  @Query(value = "select * from  fulltextrequestinfo  where pmid=?1", nativeQuery = true)
  FullTextRequest findByPmId(Integer pmid);

  @Query(value = "select max(RequestID) from fulltextrequestinfo", nativeQuery = true)
  int findMaxRequestId();

  @Query(value = "select * from fulltextrequestinfo ORDER BY creationDate DESC limit 10 ", nativeQuery = true)
  List<FullTextRequest> findLastest10Records();

  @Query(value = "select * from fulltextrequestinfo where "
    + " CASE WHEN :status IS NOT NULL THEN status= :status ELSE status LIKE '%' OR status IS NULL END"
    + " AND CASE WHEN :priority IS NOT NULL THEN priority= :priority ELSE priority LIKE '%' OR priority IS NULL END"
    + " AND CASE WHEN :pmId IS NOT NULL THEN pmId= :pmId ELSE pmId LIKE '%' OR pmId IS NULL END"
    + " AND CASE WHEN :costCenter IS NOT NULL THEN cost= :costCenter ELSE cost LIKE '%' OR cost IS NULL END"
    + " AND CASE WHEN :from IS NOT NULL THEN creationdate between  :from and :to ELSE creationdate LIKE '%' OR creationdate IS NULL END"
    + "   ORDER BY creationDate DESC limit :pageNumber , :pageSize  ", nativeQuery = true)
  List<FullTextRequest> getAllRequestsBasedOnSearchTemplate(@Param("status") String status,
    @Param("priority") String priority,
    @Param("pmId") String pmId, @Param("costCenter") String costCenter,
    @Param("pageNumber") Integer pageNumber, @Param("pageSize") Integer pageSize,
    @Param("from") String from, @Param("to") String to);

  @Query(value = "select count(*) from fulltextrequestinfo where "
    + " CASE WHEN :status IS NOT NULL THEN status= :status ELSE status LIKE '%' OR status IS NULL END"
    + " AND CASE WHEN :priority IS NOT NULL THEN priority= :priority ELSE priority LIKE '%' OR priority IS NULL END"
    + " AND CASE WHEN :pmId IS NOT NULL THEN pmId= :pmId ELSE pmId LIKE '%' OR pmId IS NULL END"
    + " AND CASE WHEN :costCenter IS NOT NULL THEN cost= :costCenter ELSE cost LIKE '%' OR cost IS NULL END"
    + " AND CASE WHEN :from IS NOT NULL THEN creationdate between  :from and :to ELSE creationdate LIKE '%' OR creationdate IS NULL END", nativeQuery = true)
  int getCountBasedOnSearchTemplate(@Param("status") String status,
    @Param("priority") String priority,
    @Param("pmId") String pmId, @Param("costCenter") String costCenter,
    @Param("from") String from, @Param("to") String to);

  @Query(value = "select * from  fulltextrequestinfo where requestid=:id", nativeQuery = true)
  FullTextRequest getFullTextRequestByRequestID(@Param("id") Integer id);

  @Modifying
  @Query(value = "update fulltextrequestinfo set status='' ,isrequested= 0,IsReviewed=0,ReviewedBy=null,ReviewedOn=null where requestid=:id ", nativeQuery = true)
  int updateFullTextRequestBasedOnId(@Param("id") Integer id);

}


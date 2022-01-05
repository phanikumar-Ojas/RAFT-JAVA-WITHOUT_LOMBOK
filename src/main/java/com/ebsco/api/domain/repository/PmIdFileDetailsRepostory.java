package com.ebsco.api.domain.repository;

import com.ebsco.data.entity.PmIdFileDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PmIdFileDetailsRepostory extends JpaRepository<PmIdFileDetails, Long> {

  @Modifying
  @Query(value = "update pmidfiledetails set deletedby= :deletedBy,deletedDate=now(),IsDeleted=1  where fileId= :fileId", nativeQuery = true)
  int updatePmIdFileDetails(@Param("fileId") Long fileId,
    @Param("deletedBy") String deletedBy);

  @Query(value = "select * from pmidfiledetails where pmId= :pmId AND type= :type", nativeQuery = true)
  PmIdFileDetails getPmIdFileDetailsByPmIdAndType(Integer pmId, String type);


}

package com.ebsco.api.domain.repository;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ebsco.data.entity.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

	@Query(value = "select * from roles limit ?1 ,?2", nativeQuery = true)
	List<Role> findAllRoles(@NotNull Integer pageSize, @NotNull Integer pageNumber);

	@Query(value = "select count(*) from roles", nativeQuery = true)
	int getRolesCount();

}

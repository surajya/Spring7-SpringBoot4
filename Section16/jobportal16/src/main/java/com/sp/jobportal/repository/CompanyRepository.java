package com.sp.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sp.jobportal.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	//JPQL Query
	@Query("SELECT DISTINCT c FROM Company c JOIN FETCH c.jobs j where j.status = :status")
	List<Company> findAllWithJobs(@Param("status") String status);

	//Native/SQL Query
	@Query(value = "SELECT DISTINCT c.* FROM companies c JOIN jobs j ON c.id = j.company_id where j.status = ?1",
			nativeQuery = true)
	List<Company> findAllWithJobsNative(String status);
}

package com.sp.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sp.jobportal.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

	@Query("SELECT c FROM Company c LEFT JOIN FETCH c.jobs where status = 'ACTIVE'")
	List<Company> findAllWithJobs();
}

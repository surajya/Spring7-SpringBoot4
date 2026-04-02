package com.sp.jobportal.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sp.jobportal.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}

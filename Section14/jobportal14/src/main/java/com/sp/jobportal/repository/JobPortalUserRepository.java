package com.sp.jobportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.jobportal.entity.JobPortalUser;

public interface JobPortalUserRepository extends JpaRepository<JobPortalUser, Long> {

	List<JobPortalUser> findJobPortalUserByEmail(String email);

	List<JobPortalUser> readUserByEmailOrMobileNumber(String email, String mobileNumber);

}

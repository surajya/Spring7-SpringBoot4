package com.sp.jobportal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.jobportal.entity.JobPortalUser;

public interface JobPortalUserRepository extends JpaRepository<JobPortalUser, Long> {

	Optional<JobPortalUser> findJobPortalUserByEmail(String email);

	Optional<JobPortalUser> readUserByEmailOrMobileNumber(String email, String mobileNumber);

}

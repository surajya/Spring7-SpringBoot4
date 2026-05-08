package com.sp.jobportal.company.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sp.jobportal.entity.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long> {

}

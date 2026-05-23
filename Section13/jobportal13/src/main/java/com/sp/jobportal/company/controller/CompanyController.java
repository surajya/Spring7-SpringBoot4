package com.sp.jobportal.company.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.company.service.CompanyService;
import com.sp.jobportal.dto.CompanyDto;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/companies")
@Slf4j
public class CompanyController {

	private final CompanyService companyService;

	public CompanyController(CompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping(path = "/public", version = "1.0")
	@CrossOrigin(origins = "http://localhost:5173/")
	public ResponseEntity<List<CompanyDto>> getAllCompanies() {
		log.info("Received request to get all companies");
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	}

}

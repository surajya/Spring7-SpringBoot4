package com.sp.jobportal.company.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.entity.Company;
import com.sp.jobportal.service.ICompanyService;

@RestController
@RequestMapping("/companies")
public class CompanyController {

	private final ICompanyService companyService;

	public CompanyController(ICompanyService companyService) {
		this.companyService = companyService;
	}

	@GetMapping(version = "1.0")
	public ResponseEntity<List<Company>> getAllCompanies() {
		return new ResponseEntity<>(companyService.getAllCompanies(), HttpStatus.OK);
	}

}

package com.sp.jobportal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.jobportal.company.repository.CompanyRepository;
import com.sp.jobportal.entity.Company;
import com.sp.jobportal.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<Company> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}


}

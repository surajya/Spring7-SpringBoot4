package com.sp.jobportal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.jobportal.company.repository.CompanyRepository;
import com.sp.jobportal.dto.CompanyDto;
import com.sp.jobportal.entity.Company;
import com.sp.jobportal.service.ICompanyService;

@Service
public class CompanyService implements ICompanyService {

	private final CompanyRepository companyRepository;

	public CompanyService(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		// TODO Auto-generated method stub
		return companyRepository.findAll().stream().map(this::transformToDto).toList();
	}

	public CompanyDto transformToDto(Company company) {
		return new CompanyDto(
				company.getId(),
				company.getName(),
				company.getLogo(),
				company.getIndustry(),
				company.getSize(),
				company.getRating(),
				company.getLocations(),
				company.getFounded(),
				company.getDescription(),
				company.getEmployees(),
				company.getWebsite(),
				company.getCreatedAt());
	}


}

package com.sp.jobportal.company.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sp.jobportal.company.repository.CompanyRepository;
import com.sp.jobportal.company.service.CompanyService;
import com.sp.jobportal.dto.CompanyDto;
import com.sp.jobportal.entity.Company;

@Service
public class CompanyServiceImpl implements CompanyService {

	private final CompanyRepository companyRepository;

	public CompanyServiceImpl(CompanyRepository companyRepository) {
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

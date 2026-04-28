package com.sp.jobportal.security.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathConfig {

	@Bean("publicPaths")
	public List<String> publicPaths() {
		return Arrays.asList("/swagger-ui/index.html", "/v3/api-docs/**");
	}

	@Bean("securePaths")
	public List<String> securePaths() {
		return Arrays.asList("/api/companies/public", "/api/contacts/public");
	}
}

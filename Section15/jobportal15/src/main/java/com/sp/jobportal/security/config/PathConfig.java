package com.sp.jobportal.security.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PathConfig {

	@Bean("publicPaths")
	public List<String> publicPaths() {
		return Arrays.asList("/swagger-ui/index.html",
				"/v3/api-docs/**",
				"/api/contacts/public",
				"/api/auth/login/public",
				"/api/companies/public",
				"/api/auth/register/public",
				"/api/csrf-token/public");
	}

	@Bean("securePaths")
	public List<String> securePaths() {
		return List.of(
				"/api/**");
	}
}

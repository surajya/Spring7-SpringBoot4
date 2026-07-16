package com.sp.jobportal.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

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

    @Bean(name = "adminPaths")
    public List<String> adminPaths() {
        return List.of(
                "/api/contacts/admin",
                "/api/contacts/sort/admin",
                "/api/contacts/page/admin",
                "/api/contacts/${id}/status/admin",
                "/api/companies/admin",
                "/api/companies/${id}/admin",
                "/api/users/search/admin",
                "/api/users/${userId}/role/employer/admin",
                "/api/users/${userId}/role/employer/admin"
        );
    }
}

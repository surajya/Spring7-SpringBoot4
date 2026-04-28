package com.sp.jobportal.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class JobPortalSecurityConfig {

	@Qualifier("securePaths")
	private final List<String> securePaths;

	@Qualifier("publicPaths")
	private final List<String> publicPaths;

	@Bean
	//@Order(SecurityFilterProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> {
					publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
					securePaths.forEach(path -> requests.requestMatchers(path).authenticated());
					requests.anyRequest().authenticated();
				})

				//requests
				//						.requestMatchers("/api/companies/public").permitAll()
				//						.requestMatchers("/api/contacts/public").permitAll())
				//						.requestMatchers(RegexRequestMatcher.regexMatcher(".*public$")).permitAll()
				//						.requestMatchers("/api/swagger-ui.html").permitAll())
				.formLogin(flc -> flc.disable())
				.httpBasic(withDefaults())
				.build();
	}


}

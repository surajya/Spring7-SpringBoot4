package com.sp.jobportal.security.config;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
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
	public AuthenticationManager authenticationManager() throws Exception {
		var authenticationProvider = new DaoAuthenticationProvider(userDetailsService());
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(authenticationProvider);
	}

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) {
		return http.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(requests -> {
					publicPaths.forEach(path -> requests.requestMatchers(path).permitAll());
					securePaths.forEach(path -> requests.requestMatchers(path).authenticated());
					requests.anyRequest().authenticated();
				})
				.formLogin(withDefaults())
				.httpBasic(withDefaults())
				.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService() {
		//		String encode = passwordEncoder().encode("suraj@123");
		//		System.out.println(encode);
		//		String encode2 = passwordEncoder().encode("anil@123");
		//		System.out.println(encode2);
		var user1 = User.builder().username("suraj")
				.password("$2a$10$/IsGESy4xTA0oSjQzF4g1e1LXqYCYmsAyXx3GC8p/0ltYGa667YoK").roles("USER")
				.build();
		var user2 = User.builder().username("anil")
				.password("$2a$10$b1tyuMJSbyJJjjs/KLeryua6xNvXZg15tD17bvaVoeM/LUNiUVgDa").roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(user1, user2);
	}

}

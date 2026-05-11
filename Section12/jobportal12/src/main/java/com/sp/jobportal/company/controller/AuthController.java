package com.sp.jobportal.company.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.dto.LoginRequestDto;
import com.sp.jobportal.dto.LoginResponseDto;
import com.sp.jobportal.dto.RegisterRequestDto;
import com.sp.jobportal.dto.UserDto;
import com.sp.jobportal.entity.JobPortalUser;
import com.sp.jobportal.repository.JobPortalUserRepository;
import com.sp.jobportal.repository.RoleRepository;
import com.sp.jobportal.security.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final PasswordEncoder passwordEncoder;
	private final JobPortalUserRepository userRepository;
	private final RoleRepository roleRepository;

	@PostMapping(path = "/login/public", version = "1.0")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
		try {
			System.out.println("username : {} password : {}" + loginRequest.username() + " " + loginRequest.password());
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.username(), loginRequest.password()));
			String jwtToken = jwtUtil.generateJwtToken(authenticate);
			LoginResponseDto response = new LoginResponseDto("Login successful", new UserDto(), jwtToken);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (BadCredentialsException ex) {
			LoginResponseDto response = new LoginResponseDto("Invalid username or password", null, null);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		} catch (AuthenticationException ex) {
			LoginResponseDto response = new LoginResponseDto("Authentication failed", null, null);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		} catch (Exception ex) {
			System.out.println("Error during authentication: " + ex.getMessage());
			LoginResponseDto response = new LoginResponseDto("An error occurred during authentication", null, null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(path = "/register/public", version = "1.0")
	public ResponseEntity<String> register(@RequestBody RegisterRequestDto registerRequestDto) {
		JobPortalUser userDetails = new JobPortalUser();
		BeanUtils.copyProperties(registerRequestDto, userDetails);
		userDetails.setPasswordHash(passwordEncoder.encode(registerRequestDto.password()));
		roleRepository.findById(1L).ifPresent(userDetails::setRole);
		userRepository.save(userDetails);
		return new ResponseEntity<>("Registration successful", HttpStatus.OK);
	}

}

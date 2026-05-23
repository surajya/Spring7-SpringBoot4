package com.sp.jobportal.auth.controller;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.password.CompromisedPasswordChecker;
import org.springframework.security.authentication.password.CompromisedPasswordDecision;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.constant.ApplicationConstants;
import com.sp.jobportal.dto.LoginRequestDto;
import com.sp.jobportal.dto.LoginResponseDto;
import com.sp.jobportal.dto.RegisterRequestDto;
import com.sp.jobportal.dto.UserDto;
import com.sp.jobportal.entity.JobPortalUser;
import com.sp.jobportal.repository.JobPortalUserRepository;
import com.sp.jobportal.repository.RoleRepository;
import com.sp.jobportal.security.util.JwtUtil;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController {

	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
	private final PasswordEncoder passwordEncoder;
	private final JobPortalUserRepository userRepository;
	private final RoleRepository roleRepository;
	private final CompromisedPasswordChecker compromisedPasswordChecker;

	@PostMapping(path = "/login/public", version = "1.0")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
		log.info("Received login request for username: {}", loginRequest.username());
		try {
			System.out.println("username : {} password : {}" + loginRequest.username() + " " + loginRequest.password());
			Authentication resultAuthenticate =
					authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
							loginRequest.username(), loginRequest.password()));
			String jwtToken = jwtUtil.generateJwtToken(resultAuthenticate);
			UserDto userDto = new UserDto();
			JobPortalUser loginUser = (JobPortalUser) resultAuthenticate.getPrincipal();
			BeanUtils.copyProperties(loginUser, userDto);
			userDto.setRole(loginUser.getRole().getName());
			userDto.setUserId(loginUser.getId());
			LoginResponseDto response = new LoginResponseDto("Login successful", userDto, jwtToken);
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
	public ResponseEntity<?> registerUser(@RequestBody RegisterRequestDto registerRequestDto) {
		log.info("Received registration request for email: {}", registerRequestDto.email());
		CompromisedPasswordDecision check = compromisedPasswordChecker.check(registerRequestDto.password());
		if (check.isCompromised()) {
			return new ResponseEntity<>(
					"The provided password has been compromised in a data breach. Please choose a different password.",
					HttpStatus.BAD_REQUEST);
		}
		Optional<JobPortalUser> existingUser = userRepository.readUserByEmailOrMobileNumber(registerRequestDto.email(),
				registerRequestDto.mobileNumber());
		if (existingUser.isPresent()) {
			return new ResponseEntity<>("User with given email or mobile number already exists",
					HttpStatus.BAD_REQUEST);
		}
		JobPortalUser userDetails = new JobPortalUser();
		BeanUtils.copyProperties(registerRequestDto, userDetails);
		userDetails.setPasswordHash(passwordEncoder.encode(registerRequestDto.password()));
		roleRepository.findRoleByName(ApplicationConstants.ROLE_JOB_SEEKER).ifPresent(userDetails::setRole);
		userRepository.save(userDetails);
		return new ResponseEntity<>("User registration successful", HttpStatus.CREATED);
	}

}

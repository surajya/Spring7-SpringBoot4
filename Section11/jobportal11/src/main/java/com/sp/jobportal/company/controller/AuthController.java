package com.sp.jobportal.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.dto.LoginRequestDto;
import com.sp.jobportal.dto.LoginResponseDto;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private AuthenticationManager authenticationManager;

	public AuthController(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@PostMapping(path = "/login/public", version = "1.0")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.username(), loginRequest.password()));
			LoginResponseDto response = new LoginResponseDto("Login successful", null, "sdkl2211kls");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (BadCredentialsException ex) {
			LoginResponseDto response = new LoginResponseDto("Invalid username or password", null, null);
			return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
		} catch (AuthenticationException ex) {
			LoginResponseDto response = new LoginResponseDto("Authentication failed", null, null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception ex) {
			LoginResponseDto response = new LoginResponseDto("An error occurred during authentication", null, null);
			return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}

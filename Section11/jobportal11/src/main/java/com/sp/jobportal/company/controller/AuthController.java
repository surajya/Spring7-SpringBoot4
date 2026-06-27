package com.sp.jobportal.company.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sp.jobportal.dto.LoginRequestDto;
import com.sp.jobportal.dto.LoginResponseDto;
import com.sp.jobportal.dto.UserDto;
import com.sp.jobportal.security.util.JwtUtil;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

<<<<<<< Updated upstream
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;
=======
	private AuthenticationManager authenticationManager;
	private JwtUtil jwtUtil;
>>>>>>> Stashed changes

	@PostMapping(path = "/login/public", version = "1.0")
	public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequest) {
		try {
			System.out.println("username : {} password : {}" + loginRequest.username() + " " + loginRequest.password());
			Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					loginRequest.username(), loginRequest.password()));
<<<<<<< Updated upstream
			String jwtToken = jwtUtil.generateJwtToken(authenticate);
			LoginResponseDto response = new LoginResponseDto("Login successful", new UserDto(), jwtToken);
=======
			//String jwtToken = jwtUtil.generateJwtToken(authenticate);
			LoginResponseDto response = new LoginResponseDto("Login successful", new UserDto(), "fksfs");
>>>>>>> Stashed changes
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
}

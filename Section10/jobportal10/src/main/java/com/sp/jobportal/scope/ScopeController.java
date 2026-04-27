package com.sp.jobportal.scope;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/scope")
@AllArgsConstructor
public class ScopeController {

	private final RequestScopeTest requestScopeTest;
	private final SessionScopeTest sessionScopeTest;
	private final ApplicationScopeTest applicationScopeTest;


	@GetMapping("/application")
	public ResponseEntity<Integer> applicationScopeTest() {
		applicationScopeTest.increment();
		return ResponseEntity.ok(applicationScopeTest.getCount());
	}

	@GetMapping("/request")
	public ResponseEntity<String> requestScopeTest() {
		requestScopeTest.setUsername("suraj yadav from request scope");
		return ResponseEntity.ok(requestScopeTest.getUsername());
	}

	@GetMapping("/session")
	public ResponseEntity<String> sessionScopeTest() {
		sessionScopeTest.setUsername("suraj yadav from session scope");
		return ResponseEntity.ok(sessionScopeTest.getUsername());
	}

	@GetMapping("/test")
	public ResponseEntity<Integer> testScope() {
		//return ResponseEntity.ok(requestScopeTest.getUsername());
		//return ResponseEntity.ok(sessionScopeTest.getUsername());
		return ResponseEntity.ok(applicationScopeTest.getCount());
	}
}

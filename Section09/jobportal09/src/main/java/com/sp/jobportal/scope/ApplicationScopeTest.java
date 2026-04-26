package com.sp.jobportal.scope;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class ApplicationScopeTest {

	int count;

	public ApplicationScopeTest() {
		System.out.println("Application Scope Bean Created");
	}

	public void increment() {
		count++;
	}
}

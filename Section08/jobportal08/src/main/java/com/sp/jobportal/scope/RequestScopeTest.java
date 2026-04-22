package com.sp.jobportal.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import lombok.Data;

@Component
@Data
@RequestScope
public class RequestScopeTest {

	String username;

	public RequestScopeTest() {
		System.out.println("Request Scope Bean Created");
	}
}

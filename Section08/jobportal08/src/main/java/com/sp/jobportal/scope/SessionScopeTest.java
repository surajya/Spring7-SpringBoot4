package com.sp.jobportal.scope;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.Data;

@Component
@Data
@SessionScope
public class SessionScopeTest {

	String username;

	public SessionScopeTest() {
		System.out.println("Session Scope Bean Created");
	}
}

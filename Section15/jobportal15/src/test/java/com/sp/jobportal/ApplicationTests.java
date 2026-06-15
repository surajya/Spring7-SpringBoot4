package com.sp.jobportal;

import java.util.TimeZone;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	static {
		// 🔥 Runs BEFORE everything (even before Spring Boot)
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}

	@Test
	void contextLoads() {
	}

}

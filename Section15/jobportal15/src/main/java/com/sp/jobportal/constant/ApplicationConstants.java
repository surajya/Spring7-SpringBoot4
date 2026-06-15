package com.sp.jobportal.constant;

public class ApplicationConstants {

	public static final String JWT_SECRET_KEY = "JWT_SECRET";
	public static final String JWT_SECRET_DEFAULT_VALUE = "jxgEQeXHuPq8VdbyYFNkANdudQ53YUn4";
	public static final String JWT_HEADER = "Authorization";
	public static final String ROLE_JOB_SEEKER = "ROLE_JOB_SEEKER";
	public static final String JOB_STATUS = "ACTIVE";

	private ApplicationConstants() {
		throw new IllegalStateException("Utility class");
	}
}

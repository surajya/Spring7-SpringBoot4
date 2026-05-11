package com.sp.jobportal.auditawareref;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditorAwareImpl")
public class AuditAwareImpl implements AuditorAware<String> {

	@Override
	public java.util.Optional<String> getCurrentAuditor() {
		return Optional.of("system_user");
	}

}

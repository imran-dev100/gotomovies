package com.sapient.gotomovies.theatre.data.helper;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component
public class Auditor implements AuditorAware<String> {
	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.of("booking-service");
	}
}

package com.eagle.springsecuritydemo.actuator.info;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthActuator implements HealthIndicator {

	@Override
	public Health health() {
		if(check()) {
			return Health.up().withDetail("checked", "UP").build();
		}
		return Health.down().withDetail("Error Code", 503).build();
	}
	
	private boolean check() {
		return false;
	}

}

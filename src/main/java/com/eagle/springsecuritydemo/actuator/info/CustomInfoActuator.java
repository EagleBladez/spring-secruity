package com.eagle.springsecuritydemo.actuator.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import com.eagle.springsecuritydemo.service.PersonReadService;

@Component
public class CustomInfoActuator implements InfoContributor {

	@Autowired
	PersonReadService reader;
	
	@Override
	public void contribute(Builder builder) {
		Map<String, Object> detail = new HashMap<>();
		detail.put("first-person", reader.getPersonById(1L));
		builder.withDetails(detail);
	}

}

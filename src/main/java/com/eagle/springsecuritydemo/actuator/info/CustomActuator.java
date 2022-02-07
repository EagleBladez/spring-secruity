package com.eagle.springsecuritydemo.actuator.info;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "custom")
@Component
public class CustomActuator {

	
	@ReadOperation
	public Map<String, String> custom(final String desc){
		Map<String, String> detail = new HashMap<String, String>();
		detail.put("name", "who");
		detail.put("phno", "+9993939");
		detail.put("desc", desc);
		return detail;
	}
	
	
}

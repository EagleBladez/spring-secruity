package com.eagle.springsecuritydemo.data;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;

public class LombokLazyLoader {
	
	@Getter(lazy = true)
	private final Map<String, String> mapData = getMapped();

	private Map<String, String> getMapped() {
		Map<String, String> mapLocalData = new HashMap<String, String>();
		
		mapLocalData.put("Aung Aung", "Student");
		mapLocalData.put("Daw Thuzar", "Worker");
		mapLocalData.put("Daw Hla", "Dependence");
		
		return mapLocalData;
	}
	
	

}

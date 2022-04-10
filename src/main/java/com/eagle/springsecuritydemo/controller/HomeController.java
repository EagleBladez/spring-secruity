package com.eagle.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.springsecuritydemo.data.Lomboker;

@RestController
public class HomeController {
	
	@GetMapping("/test")
	public String test() {
		return "Test";
	}
	
	@GetMapping("/lombok")
	public Lomboker lombok() {
		
/*		return Lomboker.builder()
			.age(1)
			.firstName("Aung Aung")
			.build();*/
		
		return new Lomboker(1, "Aung Aung", "Htet", 2);
		
		 
		/*
		 * return Lomboker.builder() .firstName("Aung Myo") .lastName("Htet") .build();
		 */
	}
}

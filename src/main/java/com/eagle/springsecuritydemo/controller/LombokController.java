package com.eagle.springsecuritydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.springsecuritydemo.data.Lomboker;
import com.eagle.springsecuritydemo.data.PersonData;
import com.eagle.springsecuritydemo.service.LombokReaderService;
import com.eagle.springsecuritydemo.service.PersonReadService;
import com.eagle.springsecuritydemo.service.PersonWriteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lombokApi")
@RequiredArgsConstructor
public class LombokController {
	
	private final PersonReadService reader;
	
	private final LombokReaderService lombokFileReader;
	
	
	@GetMapping("/getOne")
	public PersonData getOne() {
		return reader.getPersonById(1L);
	}
	
	@GetMapping("/readFile")
	public String readFile() throws Exception {
		return lombokFileReader.readFile();
	}


}

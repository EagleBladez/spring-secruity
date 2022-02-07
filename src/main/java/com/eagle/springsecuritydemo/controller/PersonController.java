package com.eagle.springsecuritydemo.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.eagle.springsecuritydemo.data.PersonData;
import com.eagle.springsecuritydemo.service.PersonWriteService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonWriteService writer;

	@PostMapping
	public String savePerson(@RequestParam(required = true, name = "name") @DefaultValue("---") String name,
			@RequestParam(required = false, name = "phno", defaultValue = "---") String phno) {
		this.writer.write(PersonData.getPersonInstance(null, name, phno));
		return "Success";
	}

	@GetMapping
	public String getTest() {
		return "Success";
	}
}

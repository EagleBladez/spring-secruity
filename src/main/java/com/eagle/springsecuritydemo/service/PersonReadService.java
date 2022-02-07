package com.eagle.springsecuritydemo.service;

import com.eagle.springsecuritydemo.data.PersonData;

public interface PersonReadService {
	
	public PersonData getPersonById(Long Id);
	
}

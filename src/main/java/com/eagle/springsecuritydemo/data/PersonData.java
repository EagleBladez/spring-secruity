package com.eagle.springsecuritydemo.data;

public class PersonData {

	private Long id;
	private String name;
	private String phno;
	
	private PersonData(final Long id, final String name, final String phno) {
		this.id = id;
		this.name = name;
		this.phno = phno;
	}
	
	public static PersonData getPersonInstance(final Long id, final String name, final String phno) {
		return new PersonData(id, name, phno);
	}
	
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPhno() {
		return phno;
	}

}

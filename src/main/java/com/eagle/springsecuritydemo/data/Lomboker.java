package com.eagle.springsecuritydemo.data;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Builder
@EqualsAndHashCode
@ToString
@Slf4j
public class Lomboker {
	
	private @Setter(AccessLevel.PROTECTED) @Getter(AccessLevel.PROTECTED) int id;
	private String firstName;
	private String lastName;
	private int  age;

	public void writeLog() {
		log.debug("this is log");
	}

}

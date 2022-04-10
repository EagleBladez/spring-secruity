package com.eagle.springsecuritydemo.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.springframework.stereotype.Service;

import lombok.Cleanup;
import lombok.SneakyThrows;
import lombok.Synchronized;

@Service
public class LombokReaderServiceImpl implements LombokReaderService{
	
	
	@Override
	@SneakyThrows
	@Synchronized
	public String readFile() {
		StringBuilder sb = new StringBuilder();
		
		File file = new File(
	            "D:\\test.txt");
		
		@Cleanup BufferedReader br = new BufferedReader(new FileReader(file));
		String st = "";
		while ((st = br.readLine()) != null) {
			sb.append(st);
		}
		
		return sb.toString();
	}

}

package com.eagle.springsecuritydemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eagle.springsecuritydemo.data.PersonData;

@Service
public class PersonWriteServiceImpl implements PersonWriteService {
	
	@Autowired
	private DataSource dataSource;

	@Override
	public void write(PersonData personData) {
		String sql = "insert into person values (null, ?, ?)";
		
		try(Connection conn = dataSource.getConnection()) {
		 PreparedStatement stmt = conn.prepareStatement(sql);
		 stmt.setString(1, personData.getName());
		 stmt.setString(2, personData.getPhno());
		 
		 stmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

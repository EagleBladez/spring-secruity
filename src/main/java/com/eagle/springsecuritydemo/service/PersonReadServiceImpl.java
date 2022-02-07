package com.eagle.springsecuritydemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eagle.springsecuritydemo.data.PersonData;

@Service
public class PersonReadServiceImpl implements PersonReadService{

	@Autowired
	DataSource dataSource;

	@Override
	public PersonData getPersonById(final Long Id) {
		try (Connection conn = dataSource.getConnection()) {
			try (PreparedStatement stmt = conn.prepareStatement("select * from person where id = ?")) {
				stmt.setLong(1, Id);
				try (ResultSet rs = stmt.executeQuery()) {
					if (rs.next()) {
						int i = 0;
						return PersonData.getPersonInstance(rs.getLong(++i), rs.getString(++i), rs.getString(++i));
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	

}

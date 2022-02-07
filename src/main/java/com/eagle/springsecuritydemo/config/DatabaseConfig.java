package com.eagle.springsecuritydemo.config;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

	/**
	 * Notice: If you use DataSourceBuilder, you have to add 
	 * 'starter-jdbc dependency' into the class-path
	 */
	@Bean
	public DataSource getDataSource() {
		System.out.println(" -------- DataSource is configuring -------- ");
		DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceBuilder.url("jdbc:mysql://localhost:3306/spring_security?serverTimezone=UTC");
		dataSourceBuilder.username("root");
		dataSourceBuilder.password("mysql");
		return dataSourceBuilder.build();
	}

}

package com.eagle.springsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("---------- Security Config Starting ----------");
		// to disable HTTP Basic Auth
		// http.httpBasic().disable();
		http
			.authorizeRequests(authorize -> {
				authorize.antMatchers(
						"/actuator", 
						"/actuator/**").permitAll();

			})
			
			// disable csrf for localhost call
			.csrf()
			.disable()
			
			.authorizeRequests()
				.anyRequest()
				.authenticated()
			
			.and()
			.formLogin()
			
			.and()
			.httpBasic();
	}
	
	/**
	 * @author Eagle
	 * This is alternative way for creating in-memory user 
	 * instead of overriding UserDetailsService Bean.
	 * 
	 * Note: .password("{noop}eagle") 
	 * 	- {noop} defines the encoder you want to use, currently 
	 * 		noop; the password will be store as plain text
	 *  - see available pass encoders at @PasswordEncoderFactories
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("eagle")
			// if there is no encoder({noob}) defines,
			// there will be an exeception
			.password("{noop}eagle")
			.roles("ADMIN")
			
			.and()
			
			.withUser("user")
			.password("{noop}user")
			.roles("USER");
		
	}
	
	
	
	/**
	 * @author Eagle
	 * Configure to provide in-memory users 
	 * Creating 2 users
	 * 	1. eagle 	[ADMIN]
	 * 	2. user		[USER]
	 * return with 	> InMemoryUserDetailsManager(UserDetails... users)
	 * 				-> implements UserDetailsManager
	 * 				--> implements UserDetailService
	 */
// 	*********** Currently Block for alternative way ************ see in auth
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails admin = User.withDefaultPasswordEncoder()
//				.username("eagle")
//				.password("eagle")
//				.roles("ADMIN")
//				.build();
//		UserDetails user = User.withDefaultPasswordEncoder()
//				.username("user")
//				.password("user")
//				.roles("USER")
//				.build();
//		return new InMemoryUserDetailsManager(admin, user);
//	}
	

}

package com.rest.service.OnlineOrders.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.rest.service.OnlineOrders.Controller.MyUserDetailService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailService myUserDetailService;
	
	@Override
	public void configure(AuthenticationManagerBuilder authManager) throws Exception {
		authManager.userDetailsService(myUserDetailService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	         .antMatchers("/createMyUser","/getMyUserByID").permitAll()
	         .antMatchers("/getAllOrders","/getOrderById","/sample").hasAnyRole("clerk","admin","supervisor")
	         .antMatchers("/CreateOrder","/").access("hasRole('ADMIN')");
	         // more lines 
	}
	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

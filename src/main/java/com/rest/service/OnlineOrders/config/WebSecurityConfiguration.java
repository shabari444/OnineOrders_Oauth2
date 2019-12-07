package com.rest.service.OnlineOrders.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//import com.rest.service.OnlineOrders.Controller.MyUserDetailService;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private static Logger LOG = LoggerFactory.getLogger(WebSecurityConfiguration.class);

	@Autowired
	//MyUserDetailService myUserDetailService;
	
	private DataSource dataSource;

	@Override
	public void configure(AuthenticationManagerBuilder authManager) throws Exception {
		
		authManager.jdbcAuthentication().
		dataSource(dataSource).
		usersByUsernameQuery("select userID, password,enabled from user where userID = ?").
		authoritiesByUsernameQuery("select userID,authority from authorities where"
				+ " userID=?");
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http
	      .authorizeRequests()
	        // .antMatchers("/CreateOrder","/").hasRole("ADMIN")
             .antMatchers("/getOrderById/*").hasAnyRole("CLERK","ADMIN","SUPERVIOSR")
             .antMatchers("/getMyUserByID","/",
            		 "/getAllOrders").permitAll();
             //.and().formLogin();// @formatter:off
			 
			// @formatter:on

	         // more lines 
	}
	
	public void configure(WebSecurity webSecurity) {
		
		webSecurity.ignoring().antMatchers("/createMyUser","/CreateOrder");
		
	}
	


	@SuppressWarnings("deprecation")
	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}

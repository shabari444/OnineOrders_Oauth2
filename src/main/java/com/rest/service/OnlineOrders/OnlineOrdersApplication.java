package com.rest.service.OnlineOrders;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@EnableAutoConfiguration
/*@ComponentScan(basePackages= {"com.rest.service.OnlineOrders",
                     "com.rest.service.Repository",
                     "com.rest.service.VO",
                     "com.rest.servie.Controller",
                     "com.rest.servie.Exception"})*/
@Configuration
@EnableEurekaClient
public class OnlineOrdersApplication {
	
	private static final Logger LOG = LoggerFactory.getLogger(OnlineOrdersApplication.class);

	public static void main(String[] args) {
		
		System.setProperty("log.name","OnlineOrders" );
		
		LOG.debug("<---------------Starting application------------------->");
		
		SpringApplication.run(OnlineOrdersApplication.class, args);
		
		LOG.debug("<-------------------Application Started----------------->");
	
	}

}

package com.productiveAnalytics;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import com.productiveAnalytics.libraryApp.controller.BookController;


/**
 * This class handles the uri : /spring-boot-restful/rest
 * 
 * @author LChawathe
 *
 */

@Configuration
@ApplicationPath("/rest")
public class RESTJerseyConfig extends ResourceConfig {
	
	@PostConstruct
	public void setUp() {
		register(BookController.class);
		register(GenericExceptionMapper.class);
	}
}

package com.eureka.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServer1Application {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(EurekaServer1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer1Application.class, args);
		LOGGER.info("Simple log statement with inputs {}, {} and {}", 1,2,3);
	}

}

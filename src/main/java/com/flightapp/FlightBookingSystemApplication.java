package com.flightapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * FlightBookingSystemApplication - Main class
 * 
 * @author Mounika
 *
 */
@SpringBootApplication
@EnableSwagger2
@EnableDiscoveryClient
public class FlightBookingSystemApplication {

	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(FlightBookingSystemApplication.class);

	/**
	 * main method triggers the application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.info("Start of main method");
		SpringApplication.run(FlightBookingSystemApplication.class, args);
		LOGGER.info("Start of main method");
	}

	/**
	 * api is a builder which is intended to be the primary interface into the
	 * swagger
	 * 
	 * @return
	 */
	@Bean
	public Docket api() {
		LOGGER.info("Start of api method");
		LOGGER.info("Start of api method");
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

}

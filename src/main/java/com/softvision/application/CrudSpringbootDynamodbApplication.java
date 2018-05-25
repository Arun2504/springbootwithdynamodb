package com.softvision.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * The Class CrudSpringbootDynamodbApplication.
 */
/**
 * @author arun.p
 *
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.softvision.*"})
public class CrudSpringbootDynamodbApplication {


	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringbootDynamodbApplication.class, args);
	}
}

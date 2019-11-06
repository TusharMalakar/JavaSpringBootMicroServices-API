package com.JavaAPI_SpringBoot.Home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Used by {@link ExceptionTranslationFilter} to commence an authentication scheme.
 * @author Tushar Malakar
 */


@SpringBootApplication
public class JavaApiSpringBootApplication {

	//main
	public static void main(String[] args) {
		SpringApplication.run(JavaApiSpringBootApplication.class, args);	
	}

}

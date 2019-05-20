package com.globallogic.firstAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Configuration

@Import(SwaggerConfig.class)
@EnableAutoConfiguration
public class FirstAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstAssignmentApplication.class, args);
	}

}

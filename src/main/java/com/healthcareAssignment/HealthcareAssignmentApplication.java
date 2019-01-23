package com.healthcareAssignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan(basePackages = { "com.healthcareAssignment.*" })
@EnableJpaRepositories(basePackages = { "com.healthcareAssignment.*" })
public class HealthcareAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthcareAssignmentApplication.class, args);
	}

}

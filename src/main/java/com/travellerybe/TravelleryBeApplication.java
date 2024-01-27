package com.travellerybe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TravelleryBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelleryBeApplication.class, args);
	}

}
package com.example.laporapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class LaporApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaporApiApplication.class, args);
	}
}

package com.example.laporapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
//@ComponentScan("com.example.laporapi")
public class LaporApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LaporApiApplication.class, args);
	}
}

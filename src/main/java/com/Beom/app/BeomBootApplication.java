package com.Beom.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BeomBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeomBootApplication.class, args);
	}
	

}

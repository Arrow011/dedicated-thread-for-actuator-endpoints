package com.example.dedicated_thread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class DedicatedThreadApplication {

	public static void main(String[] args) {
		SpringApplication.run(DedicatedThreadApplication.class, args);
	}

}

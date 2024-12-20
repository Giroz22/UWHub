package com.waveghost.uwhub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.waveghost.uwhub")
public class UwHubApplication {

	public static void main(String[] args) {
		SpringApplication.run(UwHubApplication.class, args);
	}

}

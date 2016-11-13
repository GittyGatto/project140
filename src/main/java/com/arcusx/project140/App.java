package com.arcusx.project140;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.arcusx")
public class App {
	public static void main(String[] args) {
		
		SpringApplication.run(App.class, args);
	
		System.err.println("ready");
	}
}
package com.molokotech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.molokotech.config")
public class QrfactoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrfactoryApplication.class, args);
	}
	
}

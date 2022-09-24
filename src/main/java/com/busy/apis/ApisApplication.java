package com.busy.apis;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@Configuration
@EnableWebMvc
public class ApisApplication extends SpringBootServletInitializer {
	
	public static void main(String[] args) {
	
		SpringApplication.run(ApisApplication.class, args);
	}
	
}

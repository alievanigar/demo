package com.example.backendmain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)//exclude = SecurityAutoConfiguration.class spring security login sehifesine yonlendirilmemesi uchun
public class BackendmainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendmainApplication.class, args);
	}

}

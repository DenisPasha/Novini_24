package com.example.novini_24;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class Novini24Application {

	public static void main(String[] args) {
		SpringApplication.run(Novini24Application.class, args);

	}
	// TODO fix caching

}

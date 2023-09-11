package com.example.novini_24;

import com.example.novini_24.config.NotionConfigProps;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
@EnableConfigurationProperties(NotionConfigProps.class)
public class Novini24Application {

	public static void main(String[] args) {
		SpringApplication.run(Novini24Application.class, args);

	}
	// TODO fix caching

}

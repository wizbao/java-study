package com.abot.es68;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class Es68Application {

	public static void main(String[] args) {
		SpringApplication.run(Es68Application.class, args);
	}

}

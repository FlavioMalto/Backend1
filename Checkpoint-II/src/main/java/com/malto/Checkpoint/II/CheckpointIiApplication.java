package com.malto.Checkpoint.II;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CheckpointIiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CheckpointIiApplication.class, args);
		PropertyConfigurator.configure("log4j.properties");
	}

}

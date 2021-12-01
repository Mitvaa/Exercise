package com.example.demo;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class ExcerciseApplication {
	
	@Autowired
	private TestDataLoader loadDefaultData;

	public static void main(String[] args) {
		SpringApplication.run(ExcerciseApplication.class, args);
	}
	
	@PostConstruct
	public void loadData() {
		loadDefaultData.loadDefaultValue();
	}
}

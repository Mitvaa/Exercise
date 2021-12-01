package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.service.TaskService;

@Component
public class TestDataLoader {
	
	@Autowired
	TaskService service;
	
	public void loadDefaultValue() {
		service.addInitialNumber(101,10);
	}

}

package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskRepo;
import com.example.demo.dto.TaskDto;
import com.example.demo.model.Task;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskService {

	@Autowired
	TaskRepo taskRepo;
	
	public Object getNextNumber(int classCode) {
		try {
			Task task=new Task();
			TaskDto t=null;
			return t;
		}
		catch (Exception e) {
			return e;
		}
		
	}
}


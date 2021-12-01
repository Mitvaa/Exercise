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
	
	public void addInitialNumber(int classCode,double value) {
		Task task=new Task();
		task.setClassCode(classCode);
		task.setValue(value);
		taskRepo.save(task);
	}
	
	public Object getNextNumber(int classCode) {
		try {
			double previous=taskRepo.getPreviousValue();
			System.out.print((previous % 9 + 1) *
		            Math.pow(10, (previous / 9)) - 1);
			Task task=new Task();
			task.setClassCode(classCode);
			double next=((previous % 9 + 1) *
		            Math.pow(10, (previous / 9)) - 1);
			TaskDto t=new TaskDto();
			t.setOldValue(previous);
			t.setNewValue(next);
			task.setValue(next);
			taskRepo.save(task);
			return t;
		}
		catch (Exception e) {
			return e;
		}
		
	}
}


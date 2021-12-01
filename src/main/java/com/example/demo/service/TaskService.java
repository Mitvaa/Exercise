package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
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
	
	public void addInitialNumber(int classCode,int value) {
		Task task=new Task();
		task.setClassCode(classCode);
		task.setValue(value);
		taskRepo.save(task);
	}
	static int getSum(int n)
	{
	    int sum = 0;
	    while (n != 0)
	    {
	        sum = sum + n % 10;
	        n = n / 10;
	    }
	    return sum;
	}
	static int nextNumber(int N)
	{
	    int i = 1;
	    int n=0;
	    while (1 != 0)
	    {
	        // Checking if number has
	        // sum of digits = N
	        if (getSum(i) == N)
	        {
	            System.out.print(i);
	            n=i;
	            break;
	        }
	        i++;
	    }
	    return n;
	}
	
//	@Async
//need to change return type to CompletableFuture
	public Object getNextNumber(int classCode) {
		try {
			int previous=taskRepo.getPreviousValue();
			Task task=new Task();
			task.setClassCode(classCode);
			int n=nextNumber(previous);
			TaskDto t=new TaskDto();
			t.setOldValue(previous);
			t.setNewValue(n);
			task.setValue(n);
			taskRepo.save(task);
			return t;
		}
		catch (Exception e) {
			return e;
		}
		
	}
}


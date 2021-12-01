package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskRepo;

@Service
public class TaskService {

	@Autowired
	TaskRepo taskRepo;
}

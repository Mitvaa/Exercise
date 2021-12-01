package com.example.demo.controller;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.TaskService;
import com.example.demo.util.DemoUtil;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin
@RestController
@RequestMapping("/")
@Slf4j
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@GetMapping("get-next-number/{classCode}")
	public ResponseEntity<Object> fetchNextNumber(@PathVariable("classCode") int classCode) {
		log.info(" inside fetchNextNumber");
		Object obj = taskService.getNextNumber(classCode);
//		CompletableFuture<Object> users1= taskService.getNextNumber(classCode);
//        CompletableFuture<Object> users2= taskService.getNextNumber(classCode);
//        CompletableFuture<Object> users3= taskService.getNextNumber(classCode);
//        CompletableFuture.allOf(users1,users2,users3).join();
		return new ResponseEntity<>(obj,
				DemoUtil.isObjectValid(obj) ? HttpStatus.OK : HttpStatus.EXPECTATION_FAILED);
	}

}

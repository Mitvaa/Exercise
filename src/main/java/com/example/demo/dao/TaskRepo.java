package com.example.demo.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Task;

@Repository
public interface TaskRepo extends CrudRepository<Task, Integer> {
	
	@Query(value = "SELECT value FROM task_tbl ORDER BY value desc limit 1;" , nativeQuery = true)
	double getPreviousValue();

}

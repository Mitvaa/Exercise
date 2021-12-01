package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "task_tbl")
@Data
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name = "class_code")
	private int classCode;
	
	private Long value;
}

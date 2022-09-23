package com.dmeritano.springaop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmeritano.springaop.entity.Teacher;
import com.dmeritano.springaop.service.TeacherService;

@RestController
public class TestController {

	@Autowired
	TeacherService service;
	
	
	@GetMapping("/add")
	public String add() {
		
		service.addTeacher(new Teacher(25, "Ramon Daniel"));
		
		return "Teacher saved";
	}

	@GetMapping("/remove")
	public String remove() {
		
		service.removeTeacher(new Teacher(78,"Jose Miguel"));
		
		return "Teacher removed";
	}	
	
}

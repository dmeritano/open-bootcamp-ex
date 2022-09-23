package com.dmeritano.springaop.service;

import org.springframework.stereotype.Service;

import com.dmeritano.springaop.entity.Teacher;

@Service
public class TeacherService {

	
	public void addTeacher(Teacher teacher) {
		
		System.out.println("Teacher saved\n" + teacher);
		
	}

	public void removeTeacher(Teacher teacher) {
		
		System.out.println("Teacher removed\n" + teacher);
		
	}
	
	
}

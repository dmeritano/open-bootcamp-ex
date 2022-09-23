package com.dmeritano.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.dmeritano.springaop.entity.Teacher;

@Aspect
@Component
public class AppAspect {
	
	@Before(value = "execution(* com.dmeritano.springaop.service.TeacherService.*(..)) and args(teacher)")
	public void beforeAdvice(JoinPoint joinPoint, Teacher teacher ) {
		System.out.println("Before method:" + joinPoint.getSignature());

		System.out.println("Creating Employee with name - " + teacher.getName() + " and id - " + teacher.getTeacherId());
	}

	@After(value = "execution(* com.dmeritano.springaop.service.TeacherService.*(..)) and args(teacher)")
	public void afterAdvice(JoinPoint joinPoint, Teacher teacher) {
		System.out.println("After method:" + joinPoint.getSignature());

		System.out.println("Successfully created Employee with name - " + teacher.getName() + " and id - " + teacher.getTeacherId());
	}
	
}

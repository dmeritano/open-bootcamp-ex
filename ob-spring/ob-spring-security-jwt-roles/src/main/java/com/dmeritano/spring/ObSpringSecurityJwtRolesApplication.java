package com.dmeritano.spring;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dmeritano.spring.entities.AppUser;
import com.dmeritano.spring.service.UserService;

@SpringBootApplication
public class ObSpringSecurityJwtRolesApplication {

	public static void main(String[] args) {
		//Beans container - Contenedor de Beans
		//SpringApplication.run(ObSpringSecurityJwtRolesApplication.class, args);
		ApplicationContext context = SpringApplication.run(ObSpringSecurityJwtRolesApplication.class, args);		
		UserService service = context.getBean(UserService.class);
		List<AppUser> list = service.findAll();		
		System.out.println("Cantidad de usuarios: " + list.size());		
	}

}

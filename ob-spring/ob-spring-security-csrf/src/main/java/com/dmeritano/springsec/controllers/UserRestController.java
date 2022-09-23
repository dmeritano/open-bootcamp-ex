package com.dmeritano.springsec.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmeritano.springsec.dto.UserDTO;

@RestController
@RequestMapping("/api")
public class UserRestController {

	
	//URLs permitidas
	@GetMapping("/hola")
	public String hola() {
		return "Hola mundo";
	}

	
	//URLs Autenticadas
	@GetMapping("/adios")
	public String adios() {
		return "Adios mundo cruel";
	}
	
	
	@PostMapping("/users")
	public String save(@RequestBody UserDTO user) {		
		System.out.println(user);		
		return "OK";
	}
	
}

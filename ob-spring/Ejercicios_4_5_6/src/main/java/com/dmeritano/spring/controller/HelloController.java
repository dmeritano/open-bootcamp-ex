package com.dmeritano.spring.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sayhello")
public class HelloController {

	@GetMapping({"/", ""})
	public String getBootstrap() {
	    return "<h1>Hello world!</h1><h3>Desde Open Bootcamp - Spring!</h3>";						
	}
	
}

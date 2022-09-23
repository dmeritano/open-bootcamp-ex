package com.dmeritano.springsec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dmeritano.springsec.dto.UserDTO;

@Controller
public class UserMvcController {

	
	@GetMapping("/users")
	public String getForm(Model model) {
		
		model.addAttribute("user", new UserDTO());
		
		return "users";
	}

	@PostMapping("/users")
	public String save(@ModelAttribute UserDTO user) {
		System.out.println(user);
		
		return "success";
	}

		
	
}

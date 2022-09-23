package com.dmeritano.spring.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmeritano.spring.entities.Laptop;
import com.dmeritano.spring.repository.LaptopRepository;

@RestController
@RequestMapping("/api/v1/laptops")
public class LaptopController {

	private LaptopRepository repository;
	
	public LaptopController(LaptopRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping({"", "/"})
	public List<Laptop> findAll(){		
		List<Laptop> laptops = repository.findAll();
		return laptops;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Laptop> findById(@PathVariable Long id){		
		Optional<Laptop> laptop = repository.findById(id);			
		if(laptop.isPresent()) {
			return ResponseEntity.ok(laptop.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping({"/", ""})
	public Laptop save(@RequestBody Laptop laptop) {
		
		Laptop savedLaptop = repository.save(laptop);
		
		return savedLaptop;
	}
}

package com.dmeritano.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmeritano.spring.entities.Laptop;
import com.dmeritano.spring.repository.LaptopRepository;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/laptops")
public class LaptopController {

	private LaptopRepository repository;

	public LaptopController(LaptopRepository repository) {
		this.repository = repository;
	}

	@GetMapping
	@Operation(description = "List of Laptops", summary = "Get all Laptops in DB")
	public List<Laptop> findAll() {
		List<Laptop> laptops = repository.findAll();
		return laptops;
	}

	@GetMapping("/{id}")
	@Operation(description = "Find a Laptop", summary = "Get Laptop by ID")
	public ResponseEntity<Laptop> findById(@PathVariable Long id) {
		Optional<Laptop> laptop = repository.findById(id);
		if (laptop.isPresent()) {
			return ResponseEntity.ok(laptop.get());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping
	@Operation(description = "Create a Laptop", summary = "Insert new Laptop to DB")
	public ResponseEntity<Laptop> save(@RequestBody Laptop laptop) {
		if (laptop.getId() != null) {
			return ResponseEntity.badRequest().build();
		}
		Laptop savedLaptop = repository.save(laptop);
		return ResponseEntity.ok(savedLaptop);
	}

	@PutMapping
	@Operation(description = "Update Laptop details", summary = "Update Laptop")
	public ResponseEntity<Laptop> update(@RequestBody Laptop laptop) {
		if (laptop.getId() == null) {
			return ResponseEntity.badRequest().build();
		}

		if (repository.existsById(laptop.getId())) {
			Laptop savedLaptop = repository.save(laptop);
			return ResponseEntity.ok(savedLaptop);
		} else {
			return ResponseEntity.notFound().build();
		}

	}

	@DeleteMapping("/{id}")
	@Operation(description = "Remove Laptop", summary = "Delete a Laptop by ID")
	public ResponseEntity<Laptop> deleteById(@PathVariable Long id) {

		if (repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping
	@Operation(description = "Warning! Remove all Laptops", summary = "Delete All Laptops in DB")
	public ResponseEntity<String> deletAll() {
		repository.deleteAll();
		return ResponseEntity.noContent().build();
	}

}

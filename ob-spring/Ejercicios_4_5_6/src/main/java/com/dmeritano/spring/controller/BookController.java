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

import com.dmeritano.spring.entities.Book;
import com.dmeritano.spring.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	private BookRepository repository;
	
	public BookController(BookRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping({"", "/"})
	public List<Book> findAll(){		
		List<Book> books = repository.findAll();
		return books;
	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> findById(@PathVariable Long id){		
		Optional<Book> book = repository.findById(id);			
		if(book.isPresent()) {
			return ResponseEntity.ok(book.get());
		}
		else {
			return ResponseEntity.notFound().build();
		}
		//Resumido lo de arriba:
		//return book.map(ResponseEntity::ok).orElseGet( () -> ResponseEntity.notFound().build());
	}
	
	@PostMapping({"/", ""})
	public Book save(@RequestBody Book book) {
		
		Book savedBook = repository.save(book);
		
		return savedBook;
	}
}

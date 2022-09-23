package com.dmeritano.spring.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dmeritano.spring.entities.Book;
import com.dmeritano.spring.repository.BookRepository;
import io.swagger.v3.oas.annotations.Operation;



@RestController
@RequestMapping("/api/v1/books")
public class BookController {

	
	private final Logger log = org.slf4j.LoggerFactory.getLogger(BookController.class);
	
	private BookRepository repository;
	
	public BookController(BookRepository repository) {
		this.repository = repository;
	}
	
	@GetMapping("")
	@Operation(description = "List of Books", summary = "Get all Books in DB")
	public List<Book> findAll(){		
		List<Book> books = repository.findAll();
		return books;
	}
	
	@GetMapping("/{id}")
	@Operation(description = "Find a Book", summary = "Get Book by ID")
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
	
	@PostMapping
	@Operation(description = "Create a Book", summary = "Insert new Book to DB")
	public ResponseEntity<Book> save(@RequestBody Book book) {		
		if (book.getId() != null) {
			log.warn("Incorrecto: se recibio un ID");
			return ResponseEntity.badRequest().build();
		}		
		Book savedBook = repository.save(book);
		return ResponseEntity.ok(savedBook);
	}
	

	@PutMapping
	@Operation(description = "Update Book details", summary = "Update Book")
	public ResponseEntity<Book> update(@RequestBody Book book) {
		if (book.getId() == null) {
			log.warn("Incorrecto: no se recibio un ID");
			return ResponseEntity.badRequest().build();
		}
		
		if (repository.existsById(book.getId())){
			Book savedBook = repository.save(book);
			return ResponseEntity.ok(savedBook); 
		}else {
			log.warn("Incorrecto: no se encontro libro por su ID");
			return ResponseEntity.notFound().build();
		}
		
	}	
	
	@DeleteMapping("/{id}")
	@Operation(description = "Remove Book", summary = "Delete a Book by ID")
	public ResponseEntity<Book> deleteById(@PathVariable Long id){

		if (repository.existsById(id)){
			repository.deleteById(id);
			return ResponseEntity.noContent().build(); 
		}else {
			log.warn("Incorrecto: no se encontro libro por su ID");
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping
	@Operation(description = "Warning! Remove all Books", summary = "Delete All Books in DB")
	public ResponseEntity<String> deletAll(){
		repository.deleteAll();
		return ResponseEntity.noContent().build();		
	}
	
}

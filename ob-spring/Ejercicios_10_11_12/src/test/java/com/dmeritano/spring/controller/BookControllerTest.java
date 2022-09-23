package com.dmeritano.spring.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.dmeritano.spring.entities.Book;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class BookControllerTest {

	private TestRestTemplate testRestTemplate;

	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@LocalServerPort
	private int port;

	@BeforeEach
	void setUp() {
		restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
		testRestTemplate = new TestRestTemplate(restTemplateBuilder);
	}

	@Test
	void findAll() {
		ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/v1/books", Book[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());

		List<Book> books = Arrays.asList(response.getBody());
		System.out.println(books.size());
	}

	@Test
	void findById_existe() {
		ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/v1/books/1", Book.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void findById_noExiste() {
		ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/v1/books/99999", Book.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void create() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = """
				{
				    "title": "At de bearch 5",
				    "author": "Carlos 3",
				    "pages": 106,
				    "price": 120.2,
				    "releaseDate": "2022-01-08",
				    "ebookVersion": false
				}
				""";

		HttpEntity<String> request = new HttpEntity<>(json, headers);
		ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);
		Book book = response.getBody();

		assertEquals(1L, book.getId());
		assertEquals("Carlos 3", book.getAuthor());
	}

}

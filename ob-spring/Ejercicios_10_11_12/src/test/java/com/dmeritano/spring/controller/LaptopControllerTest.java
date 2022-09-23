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

import com.dmeritano.spring.entities.Laptop;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class LaptopControllerTest {

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
		ResponseEntity<Laptop[]> response = testRestTemplate.getForEntity("/api/v1/laptops", Laptop[].class);

		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());

		List<Laptop> laptops = Arrays.asList(response.getBody());
		System.out.println(laptops.size());
	}

	@Test
	void findById_existe() {
		ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/v1/laptops/1", Laptop.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
	}

	@Test
	void findById_noExiste() {
		ResponseEntity<Laptop> response = testRestTemplate.getForEntity("/api/v1/laptops/99999", Laptop.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}

	@Test
	void create() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		String json = """
				   {
				       "brand": "DELL",
				       "model": "D18D1",
				       "screenSize": "13",
				       "color": "Grey",
				       "hardDisk": "256GB SD",
				       "memory": "8GB",
				       "price": 405.0
				   }
				""";

		HttpEntity<String> request = new HttpEntity<>(json, headers);
		ResponseEntity<Laptop> response = testRestTemplate.exchange("/api/laptops", HttpMethod.POST, request,
				Laptop.class);
		Laptop laptop = response.getBody();

		assertEquals(1L, laptop.getId());
		assertEquals("D1821", laptop.getModel());

	}

}

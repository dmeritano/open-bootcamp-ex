package com.dmeritano.spring.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import com.dmeritano.spring.entities.Book;

class BookPriceCalculatorTest {

	@Test
	void test() {
		BookPriceCalculator calculator = new BookPriceCalculator();
		Book book = new Book(1L, "Titulo", "Autor", 100, 100.99, LocalDate.now(), true);
		double price = calculator.calculatePrice(book);
		System.out.println("Precio: " + price);

		assertTrue(price > 0);
		assertEquals(price, 103.97999999999999);
		assertEquals(price, 100);

	}

	@Test
	void testDos() {
		BookPriceCalculator calculator = new BookPriceCalculator();
		Book book = new Book(1L, "Titulo", "Autor", 100, 100.99, LocalDate.now(), true);
		double price = calculator.calculatePrice(book);
		System.out.println("Precio: " + price);

		assertTrue(price > 0);

	}

}

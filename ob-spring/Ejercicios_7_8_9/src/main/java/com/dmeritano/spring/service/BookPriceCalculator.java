package com.dmeritano.spring.service;

import com.dmeritano.spring.entities.Book;

public class BookPriceCalculator {

	
	public double calculatePrice(Book book) {
		
		double price = book.getPrice();
		
		if (book.getPages() > 300) {
			price += 5;
		}
		
		//costo de envio
		price += 2.99;
		
		return price;
	}
	
}

package com.dmeritano.spring;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.dmeritano.spring.entities.Book;
import com.dmeritano.spring.entities.Laptop;
import com.dmeritano.spring.repository.BookRepository;
import com.dmeritano.spring.repository.LaptopRepository;

@SpringBootApplication
public class ObRestDatajpaApplication {

	public static void main(String[] args) {
		
		ApplicationContext context = SpringApplication.run(ObRestDatajpaApplication.class, args);
		
		BookRepository bookRepository = context.getBean(BookRepository.class);
		LaptopRepository laptopRepository = context.getBean(LaptopRepository.class);
		
		//Creamos unos libros		
		List<Book> books = new ArrayList<>(Arrays.asList(
					new Book(null,"At de bearch", "Carlos",105,120.20d,LocalDate.of(2020, 1, 8),true),
					new Book(null,"Sicarios", "Miguel S",216,318d,LocalDate.of(2017, 10, 18),false),
					new Book(null,"At de bearch (Reloaded)", "Carlos",153,220.18d,LocalDate.of(2012, 3, 4),true)
				));
		
		bookRepository.saveAll(books);
		

		//Creamos algunas laptops
		List<Laptop> laptops = new ArrayList<>(Arrays.asList(
				new Laptop(null,"DELL","D18D1", "13", "Grey", "256GB SD","8GB",405d),
				new Laptop(null,"LENOVO","L2320", "13.3", "Blue", "512GB SD","12GB",636.99d),
				new Laptop(null,"TOSHIBA","XS 10", "14.2", "White", "756GB SD","16GB",750d),
				new Laptop(null,"SONY","SX PRO", "15.1", "Silver", "1TB SD","32GB",999.99d)
			));
		
		laptopRepository.saveAll(laptops);
		
	}

}

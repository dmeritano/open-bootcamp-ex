package com.dmeritano.springdata;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringDataApplication.class, args);
		
		CocheRepository repository = context.getBean(CocheRepository.class);
		
		List<Coche> coches = new ArrayList<>(Arrays.asList(
				new Coche(null, "FIAT", "Uno S", 2019),
				new Coche(null, "BMW", "Z Speeder", 2021),
				new Coche(null, "AUDI", "TT S250", 2022)));

					
		repository.saveAll(coches);
		
		System.out.println("Cantidad de coches: " + 
					repository.count() + 
					"\nLista de coches\n" + 
					"---------------");
		
		List<Coche> cochesDb = repository.findAll();
		cochesDb.forEach(System.out::println);
		
		
		/*  Sample output:
		 
			Cantidad de coches: 3
			Lista de coches
			---------------
			Coche [id=1, manufacturer=FIAT, model=Uno S, year=2019]
			Coche [id=2, manufacturer=BMW, model=Z Speeder, year=2021]
			Coche [id=3, manufacturer=AUDI, model=TT S250, year=2022]				
		
		*/
	}

}

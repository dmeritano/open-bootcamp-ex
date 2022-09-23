package com.dmeritano.spring;



import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dmeritano.spring.entities.AppUser;
import com.dmeritano.spring.entities.Car;
import com.dmeritano.spring.repository.AppUserRepository;
import com.dmeritano.spring.service.CarService;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Car Stroe", 
								description = "Cars Rest API", 
								contact = @Contact(name = "Administrator", 
								url = "www.carone.com", 
								email = "info@carone.com"), 
								license = @License(name = "MIT Licence", 
								url = "https://opensource.org/licenses/MIT")), 
								servers = @Server(url = "http://localhost:8080"))
//  https://www.baeldung.com/spring-rest-openapi-documentation
//  migrating from springfox to springdoc-openapi-ui:   https://springdoc.org/#migrating-from-springfox
//  
public class ObSpringSecurityJwtApplication {

	public static void main(String[] args) {

		//Beans container - Contenedor de Beans
		ApplicationContext context = SpringApplication.run(ObSpringSecurityJwtApplication.class, args);

		final Logger log = LoggerFactory.getLogger(ObSpringSecurityJwtApplication.class);		
		
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class);		
		
		AppUserRepository userRepository = context.getBean(AppUserRepository.class);	
		CarService carService = context.getBean(CarService.class);

		// Creamos unos usuarios
		List<AppUser> users = new ArrayList<>(Arrays.asList(
				new AppUser("dmeritano","dmeritano@mail.net", encoder.encode("1234")),
				new AppUser("admin","admin@mail.net", encoder.encode("1234"))));

		userRepository.saveAll(users);
		log.info("Usuarios insertados: " + userRepository.count());
		
		List<Car> cars = new ArrayList<>(Arrays.asList(
				new Car("FIAT","UNOSX", 1230d, 4,2020, LocalDate.of(2020,3,4),true),
				new Car("ALFA ROMEO","QUADRIFOGLIO", 2123d, 3,2022, LocalDate.of(2021,6,14),true),
				new Car("LANCIA","SpyderSX", 1550d, 5,2022, LocalDate.of(2022,5,24),true)));		
		
		carService.saveAll(cars);
		
		log.info("Cars insertados: " + carService.count());

	}

}

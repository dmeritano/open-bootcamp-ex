package com.dmeritano.cifrado;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);

		UsuarioRepository repository = context.getBean(UsuarioRepository.class);

		//O generamos un encoder como sigue:
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		/* crear en otra clase ..y pedirselo a context
			@Bean
			public PasswordEncoder passwordEncoder(){
				return new BCryptPasswordEncoder 
			}
		 
		 	PasswordEncoder encoder = context.getBean(PasswordEncoder.class);
		 */
		
		// Creamos unos usuarios
		List<Usuario> usuarios = new ArrayList<>(
				Arrays.asList(new Usuario(null, "dmeritano", encoder.encode("pwd1234"), "David Meritano"),
						new Usuario(null, "julietaf", encoder.encode("pwd5678"), "Julieta F")));

		repository.saveAll(usuarios);

		usuarios = repository.findAll();

		usuarios.forEach((usuario) -> System.out.println(usuario.getPassword()));

		
	}

}

package com.dmeritano.cifrado;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class EncryptionTest {

	/**
	 * BCrpyt genera sus propio salt de 16 bytes El resultado de cifrar en bcrypt es
	 * un string 60 caracteres que comienza por ... $2a -> version $10 -> fuerza (va
	 * de 4 a 31, siendo 10 el valor de fuerza por defecto) Los 22 caracteres
	 * siguientes son el salt generado
	 */
	@Test
	void bcryptTest() {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pwd = "David123";
		String pwdEncoded = encoder.encode(pwd);

		System.out.println(pwd + " -> " + pwdEncoded);

		assertTrue(encoder.matches(pwd, pwdEncoded));

	}

	@Test
	void pbkdf2() {
		Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();
		for (int i = 0; i < 30; i++)
			System.out.println(passwordEncoder.encode("admin"));
	}

	@Test
	void argon() {
		Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();
		for (int i = 0; i < 30; i++)
			System.out.println(passwordEncoder.encode("admin"));
	}

	@Test
	void scrypt() {
		SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();
		for (int i = 0; i < 30; i++)
			System.out.println(passwordEncoder.encode("admin"));
	}

	@Test
	void springPasswordEncoders() {

		Map<String, PasswordEncoder> encoders = new HashMap<>();
		encoders.put("bcrypt", new BCryptPasswordEncoder());
		encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
		encoders.put("argon2", new Argon2PasswordEncoder());
		encoders.put("scrypt", new SCryptPasswordEncoder());
		// no seguro:
		//encoders.put("noop", NoOpPasswordEncoder.getInstance());
		//encoders.put("sha256", new StandardPasswordEncoder());

		PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

		String hashedPassword = passwordEncoder.encode("admin");
		System.out.println(hashedPassword);

	}

}

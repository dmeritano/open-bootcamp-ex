package com.dmeritano.springsec.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
		.and()
		.authorizeRequests()
		.antMatchers("/api/hola").permitAll()
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
		PasswordEncoder encoder = passwordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser("user")
			.password(encoder.encode("1234")).roles("USER")
			.and()
			.withUser("admin")
			.password(encoder.encode("1234")).roles("USER", "ADMIN");
			
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	
	
	
	
}

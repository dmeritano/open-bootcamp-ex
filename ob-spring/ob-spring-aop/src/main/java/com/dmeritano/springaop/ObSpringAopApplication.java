package com.dmeritano.springaop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;


@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class ObSpringAopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObSpringAopApplication.class, args);
	}

}

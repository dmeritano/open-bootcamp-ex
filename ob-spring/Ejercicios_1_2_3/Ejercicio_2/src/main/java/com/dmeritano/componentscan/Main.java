package com.dmeritano.componentscan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

	    UserService userService = (UserService)context.getBean("userService");
	
	    userService.imprimirSaludo();
	    
        ((ConfigurableApplicationContext)context).close();	    

	}

}

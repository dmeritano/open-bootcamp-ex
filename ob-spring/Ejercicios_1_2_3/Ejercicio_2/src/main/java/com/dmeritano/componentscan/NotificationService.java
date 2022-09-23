package com.dmeritano.componentscan;

import org.springframework.stereotype.Component;

@Component
public class NotificationService {

	public void saludar() {
		System.out.println("Hello Spring - Component Scan");		
	}

}

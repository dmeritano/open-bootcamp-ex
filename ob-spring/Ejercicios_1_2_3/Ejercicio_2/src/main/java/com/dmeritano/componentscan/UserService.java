package com.dmeritano.componentscan;

import org.springframework.stereotype.Component;

@Component
public class UserService {

	private NotificationService notificationService;
	
	public UserService(NotificationService notificationService) {
		this.notificationService = notificationService;
	}
	
	public void imprimirSaludo() {
		notificationService.saludar();
	}
}

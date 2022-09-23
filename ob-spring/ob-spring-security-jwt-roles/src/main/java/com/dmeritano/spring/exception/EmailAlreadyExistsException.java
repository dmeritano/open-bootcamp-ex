package com.dmeritano.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {

    private static final long serialVersionUID = 1L;

	public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}

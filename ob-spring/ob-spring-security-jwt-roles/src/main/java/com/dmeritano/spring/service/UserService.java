package com.dmeritano.spring.service;

import com.dmeritano.spring.entities.AppUser;
import com.dmeritano.spring.dto.UserDto;

import java.util.List;

public interface UserService {
	AppUser save(UserDto user);

	List<AppUser> findAll();

	AppUser findOne(String username);
}

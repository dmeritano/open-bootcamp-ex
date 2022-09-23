package com.dmeritano.spring.service;


import com.dmeritano.spring.entities.AppRole;

public interface RoleService {
	AppRole findByName(String name);
}

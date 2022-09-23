package com.dmeritano.spring.repository;

import com.dmeritano.spring.entities.AppUser;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, Long> {
	AppUser findByUsername(String username);
    boolean existsByEmail(String email);
}
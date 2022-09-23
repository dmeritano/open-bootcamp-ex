package com.dmeritano.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmeritano.spring.entities.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long>{

	Optional<AppUser> findByUsername(String username);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
	
}
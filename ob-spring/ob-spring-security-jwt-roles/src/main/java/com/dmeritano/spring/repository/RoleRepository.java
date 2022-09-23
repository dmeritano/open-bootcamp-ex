package com.dmeritano.spring.repository;

import com.dmeritano.spring.entities.AppRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<AppRole, Long> {
	AppRole findRoleByName(String name);
}
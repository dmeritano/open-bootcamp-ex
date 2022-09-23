package com.dmeritano.spring.service;

import com.dmeritano.spring.entities.AppRole;
import com.dmeritano.spring.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public AppRole findByName(String name) {
        return roleRepository.findRoleByName(name);
    }
}

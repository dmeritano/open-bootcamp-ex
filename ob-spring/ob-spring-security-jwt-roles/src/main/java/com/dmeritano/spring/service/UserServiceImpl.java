package com.dmeritano.spring.service;

import com.dmeritano.spring.entities.AppRole;
import com.dmeritano.spring.entities.AppUser;
import com.dmeritano.spring.dto.UserDto;
import com.dmeritano.spring.exception.EmailAlreadyExistsException;
import com.dmeritano.spring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bcryptEncoder;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
    }

    private Set<SimpleGrantedAuthority> getAuthority(AppUser user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        });
        return authorities;
    }

    public List<AppUser> findAll() {
        List<AppUser> list = new ArrayList<>();
        userRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public AppUser findOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public AppUser save(UserDto user) {

    	AppUser nUser = user.getUserFromDto();

        if(userRepository.existsByEmail(nUser.getEmail()))
            throw new EmailAlreadyExistsException("Email ocupado");

        nUser.setPassword(bcryptEncoder.encode(user.getPassword()));

        AppRole role = roleService.findByName("USER");
        Set<AppRole> roleSet = new HashSet<>();
        roleSet.add(role);

        if(nUser.getEmail().split("@")[1].equals("admin.edu")){
            role = roleService.findByName("ADMIN");
            roleSet.add(role);
        }

        nUser.setRoles(roleSet);
        return userRepository.save(nUser);
    }
}

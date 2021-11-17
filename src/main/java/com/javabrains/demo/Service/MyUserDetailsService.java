package com.javabrains.demo.Service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javabrains.demo.Model.AppUser;
import com.javabrains.demo.Model.Role;
import com.javabrains.demo.Repository.RoleRepository;
import com.javabrains.demo.Repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new User("foo", "foo", new ArrayList<>());
	}
	
	public Role saveRole(Role role) {
		return roleRepo.save(role);	
	}
	
	public AppUser saveUser(AppUser user) {
		return userRepo.save(user);
	}
	
	public AppUser addRoleToUser(String username, String rolename) {
		AppUser user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(rolename);
		user.getRoles().add(role);
		return user;
		
	}

}

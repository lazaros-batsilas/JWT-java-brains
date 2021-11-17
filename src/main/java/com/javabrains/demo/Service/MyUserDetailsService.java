package com.javabrains.demo.Service;

import com.javabrains.demo.Model.AppUser;
import com.javabrains.demo.Model.Role;

public interface MyUserDetailsService {

	Role saveRole(Role role);

	AppUser saveUser(AppUser user);

	AppUser addRoleToUser(String username, String rolename);

}
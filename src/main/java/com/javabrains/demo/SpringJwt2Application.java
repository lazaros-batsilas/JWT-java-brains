package com.javabrains.demo;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javabrains.demo.Model.AppUser;
import com.javabrains.demo.Model.Role;
import com.javabrains.demo.Service.MyUserDetailsService;

@SpringBootApplication
public class SpringJwt2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwt2Application.class, args);
	}
	
	@Bean
	CommandLineRunner run(MyUserDetailsService userDetailsService) {
		return args->{
			userDetailsService.saveRole(new Role(null, "ROLE_USER"));
			userDetailsService.saveRole(new Role(null, "ROLE_MANAGER"));
			userDetailsService.saveRole(new Role(null, "ROLE_ADMIN"));
			userDetailsService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
//			userDetailsService.saveUser(new AppUser(null, "John Travolta", "john", "pass", new ArrayList<Role>()));
//			userDetailsService.saveUser(new AppUser(null, "Will Smith", "will", "pass", new ArrayList<Role>()));
//			userDetailsService.saveUser(new AppUser(null, "Jim Carey", "jim", "pass", new ArrayList<Role>()));
//			userDetailsService.saveUser(new AppUser(null, "Arnold Schwarzenegger", "arnold", "pass", new ArrayList<Role>()));
//
//			userDetailsService.addRoleToUser("john", "ROLE_USER");
//			userDetailsService.addRoleToUser("john", "ROLE_MANAGER");
//			userDetailsService.addRoleToUser("will", "ROLE_MANAGER");
//			userDetailsService.addRoleToUser("jim", "ROLE_ADMIN");
//			userDetailsService.addRoleToUser("arnold", "ROLE_SUPER_ADMIN");
//			userDetailsService.addRoleToUser("arnold", "ROLE_ADMIN");
//			userDetailsService.addRoleToUser("arnold", "ROLE_USER");

		};
	}

}

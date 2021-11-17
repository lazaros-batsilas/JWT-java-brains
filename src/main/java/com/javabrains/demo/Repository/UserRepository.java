package com.javabrains.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabrains.demo.Model.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long>{

	public AppUser findByUsername(String username);
}

package com.javabrains.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javabrains.demo.Model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}

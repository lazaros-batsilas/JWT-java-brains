package com.javabrains.demo.Model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AppUser {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String user;
	private String username;
	private String password;
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<Role> roles = new ArrayList<Role>();
}

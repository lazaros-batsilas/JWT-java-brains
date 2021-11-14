package com.javabrains.demo.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javabrains.demo.Model.AuthenticationRequest;
import com.javabrains.demo.Model.AuthenticationResponse;
import com.javabrains.demo.Service.MyUserDetailsService;
import com.javabrains.demo.Utils.JWTUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class UserController {
	
	private final MyUserDetailsService userDetailsService;
	private final AuthenticationManager authenticationManagerBean;
	private final JWTUtils jwtUtils; 
	
	
	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		log.info("Inside hello method");
		return "Hello World";
	}
	
	@RequestMapping(value="/authenticate", method=RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception{
		try {
			authenticationManagerBean.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new Exception("Invalid Credentials", e);
		}
		
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());	
		final String jwt = jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok().body(new AuthenticationResponse(jwt));
	}

}

package com.springboot.expencemanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.expencemanager.dto.UserDTO;
import com.springboot.expencemanager.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public String addUser(@RequestBody UserDTO userDTO) {
		return userService.addUser(userDTO);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody UserDTO userDTO) throws InterruptedException {
		return userService.loginUser(userDTO);
	}
}

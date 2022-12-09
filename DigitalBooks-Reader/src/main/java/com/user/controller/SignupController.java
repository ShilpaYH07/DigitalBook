package com.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.User;
import com.user.service.ISignUpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SignupController {

	@Autowired
	ISignUpService signupService;

	@GetMapping("/{userId}")
	public ResponseEntity<?> getUser(@PathVariable("userId") int userId) {

		User user = signupService.getUser(userId);
		return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createUser(@RequestBody User user) {
		System.out.println(user.getUserName());
		return ResponseEntity.status(HttpStatus.CREATED).body((signupService.createUser(user)));

	}

	// Login for user

	@PostMapping("/login")
	public ResponseEntity<?> getUserByNameAndPassword(@RequestBody User loginUser) {

		User user = signupService.getUserByUserNameAndPassword(loginUser.getUserName(), loginUser.getPassword());
		if (user != null) {
			return new org.springframework.http.ResponseEntity<>(user, HttpStatus.OK);

		} else {
			return new org.springframework.http.ResponseEntity<>("Not found", HttpStatus.NOT_FOUND);
		}

	}

			



}

package com.signup.controller;

import java.util.List;
import java.util.Optional;

import com.signup.model.LoginResponse;
import com.signup.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.signup.model.RegisterUser;
import com.signup.service.ISignUpService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class SignupController {

	@Autowired
	ISignUpService signupService;

	LoginResponse lr = new LoginResponse();

	@PostMapping("/signup")
	public Integer RegisterUser(@RequestBody RegisterUser user) {
		return signupService.registerUser(user);
	}

	@PostMapping("/login")
	public String LoginUser(@RequestBody User userdata) {
		System.out.println(userdata);
		System.out.println("email: "+userdata.getEmail());
		System.out.println("password:"+userdata.getPassword());
		Optional<RegisterUser> user = signupService.findUserByEmail(userdata.getEmail());

		if (user.isPresent()) {
			RegisterUser rs = user.get();
			if (rs.getPassword().equals(userdata.getPassword()) && rs.getRole()==userdata.getRole()) {
				System.out.println(true);
				return "auth";
			}

		}
		return "notAuth";
			

	}
	@GetMapping("/getalluser")
	public List<RegisterUser> getAllUser(){
		return signupService.getAllUser();
	}

}

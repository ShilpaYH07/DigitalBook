package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;

@RestController
public class UserController {
    
	@Autowired
	UserService userService;
	
	@PostMapping("/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return ResponseEntity.ok().body(userService.saveUser(user));
		
	}
	
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) 
	{
		return ResponseEntity.ok().body(userService.getUserById(id));	
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<User>> getUsers() 
	{
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PutMapping("/user/{id}")  //http://localhost:9000
	public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User user) 
	{
		user.setUserId(id);
		return ResponseEntity.ok().body(userService.updateUser(user));		
	}

	@DeleteMapping("/user/{id}")      //http://localhost:9000
	public ResponseEntity<String> deleteUser(@PathVariable long id) 
	{
		userService.deleteUser(id);
		return ResponseEntity.ok().body("Record deleted");
	}
	
}

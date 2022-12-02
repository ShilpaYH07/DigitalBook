package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.error.RecordNotFoundException;
import com.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User getUserById(long id) {
	 Optional<User> userDb = userRepository.findById(id);
	
	 if(userDb.isPresent())
	 {
		User u = userDb.get();
		return u;
	 }
	 else
	 {
		 throw new RecordNotFoundException("Record not found");
	 }
	}

	@Override
	public List<User> getUsers() {
	  return userRepository.findAll();
	}

	@Override
	public User updateUser(User user) {
		Optional<User> userDb = userRepository.findById(user.getUserId());	
		
		if(userDb.isPresent())
		 {
			User userUpdate = userDb.get();
			userUpdate.setEmail(user.getEmail());
			userRepository.save(userUpdate);
			return userUpdate;
		 }
		 else
		 {
			 throw new RecordNotFoundException("Record not found");
		 }
	}

	@Override
	public void deleteUser(long id) {
		Optional<User> userDb = userRepository.findById(id);	
		
		if(userDb.isPresent())
		 {
			 userRepository.delete(userDb.get());
			 	
		 }
		 else
		 {
			 throw new RecordNotFoundException("Record not found");
		 }

	}

	@Override
	public User getEmployeeById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

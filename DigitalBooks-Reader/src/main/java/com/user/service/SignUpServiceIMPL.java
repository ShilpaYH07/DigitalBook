package com.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.Repository.ISignupRepository;
import com.user.model.User;

@Service
public class SignUpServiceIMPL implements ISignUpService {

	@Autowired
	ISignupRepository signupRepository;

	@Override
	public User createUser(User user) {

		User createdUser = signupRepository.save(user);
		return createdUser;
	}

	@Override
	public User getUser(int userId) {
		Optional<User> optional = signupRepository.findById(userId);
		User user = optional.get();
		return user;
	}

	@Override
	public User getUserByUserNameAndPassword(String userName, String password) {

		List<User> users = signupRepository.findAll();
		for (User user : users) {

			if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
				return (user);

			}
		}
		return null;

	}
	
}

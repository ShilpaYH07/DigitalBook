package com.user.service;

import com.user.model.User;

public interface ISignUpService {

	public User getUser(int userId);
	public User createUser(User user);
	public User getUserByUserNameAndPassword(String userName, String password);

}

package com.demo.service;

import java.util.List;

import com.demo.entity.User;

public interface UserService 
{
   public User saveUser(User user);
   public User getEmployeeById(long id);
   public List<User> getUsers();
   public User updateUser(User user);
   public void deleteUser(long id);
User getUserById(long id);  
}

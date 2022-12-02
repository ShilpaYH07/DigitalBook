package com.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
 //JpaRepository is built in interface in Spring framework, it has many DB related functionalities 
	
	
}

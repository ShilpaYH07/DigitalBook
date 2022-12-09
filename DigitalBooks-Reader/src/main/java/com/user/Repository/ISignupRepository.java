package com.user.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.user.model.User;

@Repository
public interface ISignupRepository extends JpaRepository<User, Integer> {
	@Query(value = "select * from User where user_Id=?1", nativeQuery = true)
	User findByUserId(int userId);

	@Query(value = "select * from User where user_Name=?1", nativeQuery = true)
	User findByUserName(String userName);

}

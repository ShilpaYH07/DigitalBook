package com.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity                      //table will created for the class automatically
@Table(name="UserTable")       //used to give name to table
public class User {
	
	@Id                 //used to create primary col
	@GeneratedValue(strategy=GenerationType.AUTO)  //used to generate PK col values automatically
	@Column(name="user_id")   //
	private long userId;
	
	@Column(name="name")
	private String name;
	
	@Column(name="email")  //we can give data member name as col name
	private String email;
	
	@Column(name="date_of_joining")
	private Date dateOfJoining;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}

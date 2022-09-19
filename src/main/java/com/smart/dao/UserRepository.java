package com.smart.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smart.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	
	/*
	 * customized method to fetch user from database JPA query to get user from db
	 * here :email used for dynamic value with the help of @Param anoatation
	 * 
	 * Note: 
	 * here in query every name  we take from our Entity class not from database tables 
	 * like user in db but in our clas =User
	 * user_email in db bit in class we have userEmail
	 * 
	 */
	
	@Query("select u from User u where u.userEmail=:email")
	public User getUserByUserName(@Param("email") String email);
	
	
}

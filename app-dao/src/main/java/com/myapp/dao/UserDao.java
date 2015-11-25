package com.myapp.dao;

import java.util.List;

import com.myapp.model.User;

public interface UserDao {

	User findUser(int id);

	void saveOrUpdateUser(User user);
	
	void deleteUser(int id);
	
	List<User> findAllUsers();

}

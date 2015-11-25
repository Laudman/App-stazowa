package com.myapp.service;

import java.util.List;

import com.myapp.model.User;

public interface UserService {
	
	User findUser(int id);

	void saveOrUpdateUser(User user);
	
	void deleteUser(int id);
	
	List<User> findAllUsers();
}

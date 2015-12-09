package com.myapp.service;

import java.util.List;

import com.myapp.model.User;

public interface UserService {
	
	User findUser(int id_user);
	
	User findUserLogin(String login);

	void saveOrUpdateUser(User user);
        
        void updateUser (User user);
	
	void deleteUser(int id_user);
	
	List<User> findAllUsers();
	
	public boolean isUserExist(User user);
}

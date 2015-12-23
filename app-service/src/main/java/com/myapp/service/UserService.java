package com.myapp.service;

import java.util.List;

import com.myapp.model.User;

public interface UserService {
	
	User findUser(int id);
	
	User findUserByLogin(String login);

	void saveUser(User user);
        
        void updateUser (User user);
	
	void deleteUser(int id);
        
        void deleteUserByLogin(String login);
	
	List<User> findAllUsers();
	
//	boolean isUserLoginUnique(Integer id_user, String login);
}

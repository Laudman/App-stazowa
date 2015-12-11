package com.myapp.dao;

import java.util.List;

import com.myapp.model.User;

public interface UserDao {

	User findUser(int id_user);
        
        User findUserByLogin(String login);

	void saveUser(User user);
        
        //void updateUser (User user);
	
	void deleteUser(int id_user);
        
        void deleteUserByLogin (String login);
	
	List<User> findAllUsers();

}

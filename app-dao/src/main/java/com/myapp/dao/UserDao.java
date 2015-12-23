package com.myapp.dao;

import java.util.List;

import com.myapp.model.User;

public interface UserDao {

	User findUser(int id);
        
        public User findUserByLogin(String login);

	void saveUser(User user);
        
        //void updateUser (User user);
	
	void deleteUser(int id);
        
        void deleteUserByLogin (String login);
	
	List<User> findAllUsers();

}

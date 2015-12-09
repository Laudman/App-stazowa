package com.myapp.dao;

import java.util.List;

import com.myapp.model.User;

public interface UserDao {

	User findUser(int id_user);

	void saveOrUpdateUser(User user);
        
        //void updateUser (User user);
	
	void deleteUser(int id_user);
	
	List<User> findAllUsers();

}

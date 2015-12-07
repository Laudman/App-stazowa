package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.UserDao;
import com.myapp.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;
	
	private static List<User> users;
	

	
	public User findUser(int id_user) {
		return dao.findUser(id_user);
	}

	public void saveOrUpdateUser(User user) {
		dao.saveOrUpdateUser(user);
	}
	
	public void updateUser(User user) {
		User entity = dao.findUser(user.getId_user());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPassword(user.getPassword());
			entity.setEmail(user.getEmail());
		}
	}

	public void deleteUser(int id_user) {
		dao.deleteUser(id_user);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public boolean isUserExist(User user) {
		return findUserLogin(user.getLogin())!=null;
	}

	public User findUserLogin(String login) {
		for(User user : users){
			if(user.getLogin().equalsIgnoreCase(login)){
				return user;
			}
		}
		return null;
	}

}

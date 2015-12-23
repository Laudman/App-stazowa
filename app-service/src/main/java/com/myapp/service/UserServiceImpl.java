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
	private UserDao userDao;
	
//	private static List<User> users;
        
	public User findUserByLogin(String login) {
        User user = userDao.findUserByLogin(login);
        return user;
    }

	
	public User findUser(int id) {
		return userDao.findUser(id);
	}

	public void saveUser(User user) {
		userDao.saveUser(user);
	}
	
	public void updateUser(User user) {
		User entity = userDao.findUser(user.getId());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPassword(user.getPassword());
			entity.setEmail(user.getEmail());
//                        entity.setUserRole(user.getUserRole());
//                        entity.setEnabled(user.isEnabled());
		}
	}

	public void deleteUser(int id) {
		userDao.deleteUser(id);
	}
        
        public void deleteUserByLogin(String login) {
        userDao.deleteUserByLogin(login);
    }

	public List<User> findAllUsers() {
		return userDao.findAllUsers();
	}

 
//    public boolean isUserLoginUnique(Integer id_user, String login) {
//        User user = findUserByLogin(login);
//        return ( user == null || ((id_user != null) && (user.getId_user() == id_user)));
//    }


}

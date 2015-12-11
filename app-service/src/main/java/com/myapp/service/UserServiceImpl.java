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
	private UserDao userdao;
	
	//private static List<User> users;
	public User findUserByLogin(String login) {
        User user = userdao.findUserByLogin(login);
        return user;
    }

	
	public User findUser(int id_user) {
		return userdao.findUser(id_user);
	}

	public void saveUser(User user) {
		userdao.saveUser(user);
	}
	
	public void updateUser(User user) {
		User entity = userdao.findUser(user.getId_user());
		if(entity!=null){
			entity.setLogin(user.getLogin());
			entity.setPassword(user.getPassword());
			entity.setEmail(user.getEmail());
                        entity.setUserProfiles(user.getUserProfiles());
		}
	}

	public void deleteUser(int id_user) {
		userdao.deleteUser(id_user);
	}
        
        public void deleteUserByLogin(String login) {
        userdao.deleteUserByLogin(login);
    }

	public List<User> findAllUsers() {
		return userdao.findAllUsers();
	}

 
    public boolean isUserLoginUnique(Integer id_user, String login) {
        User user = findUserByLogin(login);
        return ( user == null || ((id_user != null) && (user.getId_user() == id_user)));
    }


}

package com.myapp.service;

import com.myapp.dao.UserDao;
import com.myapp.model.Authority;
import com.myapp.model.User;
import com.myapp.service.exceptions.LoginExistsException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User findUserByLogin(String login) {
        return userDao.findUserByLogin(login);
    }

    public User findUser(Long userId) {
        return userDao.findUser(userId);
    }

    public void registerUser(User user) throws LoginExistsException {
        if(loginExists(user.getEmail())){
            throw new LoginExistsException();
        }
        
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.addAuthority(new Authority("USER", user));
        
        userDao.saveUser(user);
    }

    public void saveUser(User user) {
        userDao.saveUser(user);
    }
    
    public void updateUser (User user) {
        userDao.updateUser(user);
    }
    
   

    public void deleteUserById(Long id) {
        userDao.deleteUserById(id);
        
    }
    
    public void deleteUserBySession(User user) {
        userDao.deleteUserBySession(user);
        
    }

    public void deleteUserByLogin(String login) {
        userDao.deleteUserByLogin(login);
    }

    public List<User> findAllUsers() {
        return userDao.findAllUsers();
    }

    private boolean loginExists(String login) {
        return userDao.findUserByLogin(login) != null;
    }

}

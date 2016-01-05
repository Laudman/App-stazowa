package com.myapp.service;

import com.myapp.model.User;
import com.myapp.service.exceptions.LoginExistsException;
import java.util.List;

public interface UserService {

    User findUser(Long id);

    User findUserByLogin(String login);

    void registerUser(User user) throws LoginExistsException;

    void saveUser(User user);


    void deleteUserById(Long id);
    
    void deleteUserBySession(User user);
    
    void saveUserBySession(User user);

    void deleteUserByLogin(String login);

    List<User> findAllUsers();
}

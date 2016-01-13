package com.myapp.dao;

import com.myapp.model.User;
import java.util.List;

public interface UserDao {

    User findUser(Long id);

    User findUserByLogin(String login);

    void saveUser(User user);
    
    void updateUser (User user);

    void deleteUserById(Long id);
    
    void deleteUserBySession(User user);

    void deleteUserByLogin(String login);

    List<User> findAllUsers();

}

package com.myapp.controller;


import com.myapp.dao.RoleDAO;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.myapp.model.User;
import com.myapp.service.UserService;
import javax.ws.rs.Produces;
import org.springframework.web.bind.annotation.ResponseBody;



@RestController
public class UserRestController {

    @Autowired
    private UserService userService;
    
    @Autowired
    private RoleDAO roleDAO;
    
    //--------------------------------------------------------------------------
    //*************************USER CONTROLLER**********************************
    //--------------------------------------------------------------------------
    
    // --------------------- version 1 ------------------------ 
    
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userService.findAllUsers();

    }
    
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = {"/users/{id}"}, method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") int id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.findUser(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

     
     
    // -------------------Create User--------------------------------------------------------
//    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = {"/users"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getLogin());

        userService.saveUser(user);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(user.getLogin()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
    }

    //------------------- Update User --------------------------------------------------------
    @ResponseBody
    @RequestMapping(value = {"/users/update"}, method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> updateUser(@RequestBody User userJSON) {
        System.out.println("Updating User " + userJSON.getId());

        User currentUser = userService.findUser(userJSON.getId());

        if (currentUser == null) {
            System.out.println("User with id " + userJSON.getId() + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        currentUser.setLogin(userJSON.getLogin());
        currentUser.setPassword(userJSON.getPassword());
        currentUser.setEmail(userJSON.getEmail());

        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

    //------------------- Delete User --------------------------------------------------------
//    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<User> deleteUser(@RequestBody User userJSON) {
        System.out.println("Fetching & Deleting User with login " + userJSON.getLogin());

        User user = userService.findUserByLogin(userJSON.getLogin());
        if (user == null) {
        
            System.out.println("Unable to delete. User with login " + userJSON.getLogin() + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserByLogin(userJSON.getLogin());
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    
//  @RequestMapping(value = "/login",method = RequestMethod.POST, consumes = "application/json")
// @ResponseBody
// public User getUser(@RequestBody User userJSON) {
// 
//     
//   return userService.findUser(userJSON.getLogin());
//   
//};
    

};
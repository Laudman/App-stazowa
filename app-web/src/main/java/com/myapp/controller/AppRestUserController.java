package com.myapp.controller;

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
public class AppRestUserController {
	
	@Autowired
    UserService userService;
        
        @Produces("application/json")
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public  ResponseEntity<List<User>> listAllUsers() {
        List<User> users = userService.findAllUsers();
        if(users.isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }
 
 
    
    //-------------------Retrieve Single User--------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/{id_user}", method = RequestMethod.GET)
    public  ResponseEntity<User> getUser(@PathVariable("id_user") int id_user) {
        System.out.println("Fetching User with id " + id_user);
        User user = userService.findUser(id_user);
        if (user == null) {
            System.out.println("User with id_user " + id_user + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
 
     
     
    //-------------------Create a User--------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST )
    public  ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getLogin());
 
//        if (userService.isUserExist(user)) {
//            System.out.println("A User with login " + user.getLogin() + " already exist");
//            return new ResponseEntity<User>(HttpStatus.CONFLICT);
//        }
 
        userService.saveOrUpdateUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id_user}").buildAndExpand(user.getId_user()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update a User --------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/{id_user}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@PathVariable("id_user") int id_user, @RequestBody User user) {
        System.out.println("Updating User " + id_user);
         
        User currentUser = userService.findUser(id_user);
         
//        if (currentUser == null) {
//            System.out.println("User with id_user " + id_user + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
 
        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setEmail(user.getEmail());
         
        userService.saveOrUpdateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    
    
    //------------------- Delete a User --------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/{id_user}", method = RequestMethod.DELETE)
    public  ResponseEntity<User> deleteUser(@PathVariable("id_user") int id_user) {
        System.out.println("Fetching & Deleting User with id_user " + id_user);
 
        User user = userService.findUser(id_user);
        if (user == null) {
            System.out.println("Unable to delete. User with id_user " + id_user + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUser(id_user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
 
     
    
    //------------------- Delete All Users --------------------------------------------------------
//    @ResponseBody
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE, produces={"application/json"})
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
// 
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
 

}

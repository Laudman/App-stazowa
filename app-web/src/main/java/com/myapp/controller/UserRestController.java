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
public class UserRestController {

    @Autowired
        private UserService userService;
    
    
    //--------------------------------------------------------------------------
    //*************************USER CONTROLLER**********************************
    //--------------------------------------------------------------------------
    
    // --------------------- version 1 ------------------------ 
//        @Produces("application/json")
//	@ResponseBody
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//    public  List<User>listAllUsers() {
//        return userService.findAllUsers();
//        
//    }
    
       @Produces("application/json")
	@ResponseBody
	@RequestMapping(value = "/users", method = RequestMethod.GET)
    public  List<User>listAllUsers() {
        return userService.findAllUsers();
        
    }
    // ----------------version 2 ---------------------------------
//     @Produces("application/json")
//	@ResponseBody
//	@RequestMapping(value = "/users", method = RequestMethod.GET)
//    public  ResponseEntity<List<User>> listAllUsers() {
//        List<User> users = userService.findAllUsers();
//        if(users.isEmpty()){
//            return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
//    }
 
 
    
    //-------------------Retrieve Single User version 1--------------------------------------------------------
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
 
     
     
   // -------------------Create User--------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users", method = RequestMethod.POST )
    public  ResponseEntity<User> addUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating User " + user.getLogin());

        userService.saveUser(user);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/users/{id_user}").buildAndExpand(user.getId_user()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
    }
 
    
     
    //------------------- Update User --------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/update", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User userJSON) {
        System.out.println("Updating User " + userJSON.getId_user());
         
        User currentUser = userService.findUser(userJSON.getId_user());
         
        if (currentUser == null) {
            System.out.println("User with id_user " + userJSON.getId_user() + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        currentUser.setLogin(userJSON.getLogin());
        currentUser.setPassword(userJSON.getPassword());
        currentUser.setEmail(userJSON.getEmail());
         
        userService.updateUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }
 
    //------------------- Delete User --------------------------------------------------------
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/users/delete", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@RequestBody User userJSON) {
        System.out.println("Fetching & Deleting User with id_user " + userJSON.getId_user());
 
        User user = userService.findUser(userJSON.getId_user());
        if (user == null) {
            System.out.println("Unable to delete. User with id_user " + userJSON.getId_user() + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
 
        userService.deleteUser(userJSON.getId_user());
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
// ------------------test version DELETE to upgrade in future -------------
//    @Produces("application/json")
//    @ResponseBody
//    @RequestMapping(value = "/users/delete/{id_user}", method = RequestMethod.POST)
//    public ResponseEntity<User> deleteUser(@PathVariable("id_user") int id_user) {
//        System.out.println("Fetching & Deleting User with id_user " + id_user);
// 
//        User user = userService.findUser(id_user);
//        if (user == null) {
//            System.out.println("Unable to delete. User with id_user " + id_user + " not found");
//            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
//        }
// 
//        userService.deleteUser(id_user);
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
     
    
    //------------------- Delete All Users --------------------------------------------------------
//    @ResponseBody
//    @RequestMapping(value = "/user/", method = RequestMethod.DELETE, produces={"application/json"})
//    public ResponseEntity<User> deleteAllUsers() {
//        System.out.println("Deleting All Users");
// 
//        userService.deleteAllUsers();
//        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
//    }
 
// *****************************END USER CONTROLLER************************************************
    
    
}

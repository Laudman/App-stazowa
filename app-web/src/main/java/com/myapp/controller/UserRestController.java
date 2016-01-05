package com.myapp.controller;

import com.myapp.model.User;
import com.myapp.service.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public List<User> listAllUsers() {
        return userService.findAllUsers();
    }

    @ResponseBody
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
        User user = userService.findUser(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/user/register", method = RequestMethod.POST)
    public ResponseEntity registerUser(@RequestBody User user) throws Exception {

        userService.registerUser(user);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @ResponseBody
    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@RequestBody User userJSON) {

        User currentUser = userService.findUser(userJSON.getId());


        if (currentUser == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        currentUser.setLogin(userJSON.getLogin());
        currentUser.setPassword(userJSON.getPassword());
        currentUser.setEmail(userJSON.getEmail());
        currentUser.setEnabled(userJSON.getEnabled());
//        currentUser.setAuthority(userJSON.getAuthority());

        userService.saveUser(currentUser);
        return new ResponseEntity<User>(currentUser, HttpStatus.OK);
    }

   @ResponseBody
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> deleteUser(@PathVariable("id") Long id) {

        User user = userService.findUser(id);
        if (user == null) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }

        userService.deleteUserBySession(user);
        return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
    }
    

    
    
}

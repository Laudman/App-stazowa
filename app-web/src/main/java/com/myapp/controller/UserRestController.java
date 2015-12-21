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
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Produces;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


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
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public List<User> listAllUsers() {
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
    @RequestMapping(value = {"/users/{id_user}"}, method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable("id_user") int id_user) {
        System.out.println("Fetching User with id " + id_user);
        User user = userService.findUser(id_user);
        if (user == null) {
            System.out.println("User with id_user " + id_user + " not found");
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
        headers.setLocation(ucBuilder.path("/users/{id_user}").buildAndExpand(user.getId_user()).toUri());
        return new ResponseEntity<User>(headers, HttpStatus.CREATED);
    }

    //------------------- Update User --------------------------------------------------------
    @ResponseBody
    @RequestMapping(value = {"/users/update"}, method = RequestMethod.POST, consumes = "application/json")
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
        //******************************************
//        currentUser.setEmail(userJSON.getState());
        //********************************************

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
    @Produces("application/json")
    @ResponseBody
    @RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security + Hibernate Example");
		model.addObject("message", "This page is for ROLE_ADMIN only!");
		model.setViewName("admin");

		return model;

	}
    @Produces("application/json")
    @ResponseBody
@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout, HttpServletRequest request) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", getErrorMessage(request, "SPRING_SECURITY_LAST_EXCEPTION"));
		}

		if (logout != null) {
			model.addObject("msg", "You've been logged out successfully.");
		}
		model.setViewName("login");

		return model;

	}

	// customize the error message
	private String getErrorMessage(HttpServletRequest request, String key) {

		Exception exception = (Exception) request.getSession().getAttribute(key);

		String error = "";
		if (exception instanceof BadCredentialsException) {
			error = "Invalid login and password!";
		} else if (exception instanceof LockedException) {
			error = exception.getMessage();
		} else {
			error = "Invalid login and password!";
		}

		return error;
	}

        
	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// check if user is login
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			System.out.println(userDetail);

			model.addObject("login", userDetail.getUsername());

		}

		model.setViewName("403");
		return model;

	}

}

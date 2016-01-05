package com.myapp.controller;

import com.myapp.model.User;
import com.myapp.service.UserService;
import java.nio.file.attribute.UserPrincipal;
import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class AppController {

    @Autowired
    private UserService userService;
    
    @RequestMapping()
    public String getHomePage() {
        return "/views/home.html";
    }

//    @RequestMapping("/user/retrive")
//    @ResponseBody
//    public Principal user(Principal user) {
//        return user;
//    }
    
    @ResponseBody
    @RequestMapping("/user/retrive")
    public Map<String, Object> user(Principal user) {
    Map<String, Object> map = new LinkedHashMap<String, Object>();
    User getuser = userService.findUserByLogin(user.getName());
    map.put("name", user.getName());
    map.put("id", getuser.getId());
    map.put("email", getuser.getEmail());
    map.put("enabled", getuser.getEnabled());
    map.put("authority", AuthorityUtils.authorityListToSet(((Authentication) user)
        .getAuthorities()));

    return map;
  }
    
        
}

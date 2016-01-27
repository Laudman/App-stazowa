package com.myapp.controller;

import com.myapp.model.Authority;
import com.myapp.model.User;
import com.myapp.service.UserService;
import java.security.Principal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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
    if(getuser.getId() != null)
    {
    map.put("name", user.getName());
    map.put("login", getuser.getLogin());
    map.put("id", getuser.getId());
    map.put("email", getuser.getEmail());
    map.put("enabled", getuser.getEnabled()); 
//    map.put("isAdmin", new ArrayList(AuthorityUtils.authorityListToSet(((Authentication) user).getAuthorities())).indexOf("ADMIN") > 0);
    boolean isAdmin = false;
    boolean isUser = false;
    for(Authority iterator: getuser.getAuthority()){
        if(iterator.getAuthority().equals("ADMIN")) {
            isAdmin = true;
            isUser = true;
        }
    }
    map.put("admin", isAdmin);
    for(Authority iterator: getuser.getAuthority()){
        if(iterator.getAuthority().equals("USER")) isUser = true;
    }
    map.put("user", isUser);
//    map.put("authority", AuthorityUtils.authorityListToSet(((Authentication) user)
//        .getAuthorities()));
    }
    return map;
    
  }
    
        
}

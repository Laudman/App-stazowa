package com.myapp.service;

import com.myapp.model.Authority;
import com.myapp.model.User;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    
    private static final String ROLE_PREFIX = "ROLE_";

    @Autowired
    private UserService userService;

    
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userService.findUserByLogin(login);
        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                user.getEnabled(), true, true, true, getGrantedAuthorities(user));
        
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

        for (Authority authority : user.getAuthority()) {
            authorities.add(new SimpleGrantedAuthority(ROLE_PREFIX + authority.getAuthority()));
        }
        return authorities;
    }

}

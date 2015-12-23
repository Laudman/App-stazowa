package com.myapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;




@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    @Qualifier("userDetailsService")
    private UserDetailsService userDetailsService;
     
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//	}
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .antMatchers("/", "/home", "/signup", "/login", "/users", "/users/new", "/users/delete").permitAll()
        .antMatchers("/user/**").access("hasRole('USER')")
        .antMatchers("/admin/**").access("hasRole('ADMIN')")
        .and().formLogin().loginPage("/login")
        .usernameParameter("login").passwordParameter("password")
        .and().csrf().disable()
        .exceptionHandling().accessDeniedPage("/Access_Denied");
        
//        http.authorizeRequests().antMatchers("/admin/**")
//		.access("hasRole('ROLE_ADMIN')").and().formLogin()
//		.loginPage("/login").failureUrl("/login?error")
//		.usernameParameter("login")
//		.passwordParameter("password")
//		.and().logout().logoutSuccessUrl("/login?logout")
//		.and().csrf()
//		.and().exceptionHandling().accessDeniedPage("/403");
    }
        
    
//    @Bean
//	public PasswordEncoder passwordEncoder(){
//		PasswordEncoder encoder = new BCryptPasswordEncoder();
//		return encoder;
//	}
}


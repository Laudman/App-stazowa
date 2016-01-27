package com.myapp.config;

import com.myapp.config.utils.UnauthorisedEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UnauthorisedEntryPoint unauthorisedEntryPoint;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .authenticationEntryPoint(unauthorisedEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/", "/static/**", "/views/tasks/tasks.html", "/tasks/guest", "views/tasks/task.html", "views/answers/answer.html", "/answers", "/tasks/task/{id_task}", "/views/tasks/task.html", "/views/answers/answer.html", "/views/users/login.html", "/views/users/signup.html").permitAll()
                .antMatchers("/user/**", "/views/tasks/mySubscribedTasks.html", "/views/tasks/myTasks.html", "/views/tasks/task-edit.html", "/views/tasks/task-new.html", "/views/users/mailBox.html", "/views/users/user.html", "/views/answers/answer-edit.html", "/views/answers/answer-new.html", "/views/answers/answer.html").hasAnyRole("USER", "ADMIN")
                .antMatchers("/admin/**", "/views/admin/tasks.html", "/views/admin/users.html").hasAnyRole("ADMIN")
                .anyRequest().authenticated()
                .and().logout()
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
                .and()
                .csrf().disable();
    }

    @Bean
    public DaoAuthenticationProvider authProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(encoder());
        return authProvider;
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(11);
    }

}

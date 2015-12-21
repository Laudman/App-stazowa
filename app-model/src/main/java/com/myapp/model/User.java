package com.myapp.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    
    @Column(unique = true)
    private String login;
    
    private String password;
    private String email;
    private boolean enabled;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<UserRole>();

    public User() {
    }

    public User(int id_user, String login, String password, boolean enabled) {
        id_user = this.id_user;
        login = this.login;
        password = this.password;
        enabled = this.enabled;
        

    }

    public User(int id_user, String login, String password, String email, boolean enabled,
            Set<UserRole> userRole) {
        enabled = this.enabled;
        id_user = this.id_user;
        login = this.login;
        password = this.password;
        email = this.email;
        userRole = this.userRole;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
//        @Column(name = "password", 
//		nullable = false, length = 60)

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(Set<UserRole> userRole) {
        this.userRole = userRole;
    }

}

package com.myapp.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;
	private String login;
	private String password;
	private String email;
        private String state=State.ACTIVE.getState();
        
                
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "userprofile", 
             joinColumns = { @JoinColumn(name = "id_user") }, 
             inverseJoinColumns = { @JoinColumn(name = "id_profile") })
        private Set<UserProfile> userProfiles = new HashSet<UserProfile>();
	
//	public User (){}
//	public User (int id_user, String login, String password, String email, boolean enabled){
//		id_user = this.id_user;
//		login = this.login;
//		password = this.password;
//		email = this.email;
//	}
//        
//        public User (int id_user, String login, String password, String email, boolean enabled,
//                     Set<UserProfile> userRole){
//                enabled = this.enabled;
//		id_user = this.id_user;
//		login = this.login;
//		password = this.password;
//		email = this.email;
//	}
	
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
        

        public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }
 
    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }
 
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id_user == null) ? 0 : id_user.hashCode());
        result = prime * result + ((login == null) ? 0 : login.hashCode());
        return result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof User))
            return false;
        User other = (User) obj;
        if (id_user == null) {
            if (other.id_user != null)
                return false;
        } else if (!id_user.equals(other.id_user))
            return false;
        if (login == null) {
            if (other.login != null)
                return false;
        } else if (!login.equals(other.login))
            return false;
        return true;
    }
 
    @Override
    public String toString() {
        return "User [id_user=" + id_user + ", login=" + login + ", password=" + password
                + ", email=" + email + "]";
    }

    public Object getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	

	
}

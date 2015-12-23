package com.myapp.model;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User implements Serializable {

	@Id
	@GeneratedValue
	private Integer id;
	
	private String login;
	
	private String password;
        
        private String email;
	
	@OneToOne(cascade=CascadeType.ALL)
        @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")})
	private Role role;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}	

}

//
//@Entity
//@Table(name = "users")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id_user")
//public class User implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id_user;
//    
//    @Column(unique = true)
//    private String login;
//    
//    private String password;
//    private String email;
//    private boolean enabled;
//
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
//    private Set<UserRole> userRole = new HashSet<UserRole>(0);
//
//    public User() {
//    }
////
////    public User( String login, String password, boolean enabled) {
////        login = this.login;
////        password = this.password;
////        enabled = this.enabled;
////        
////
////    }
//
//    public User (int id_user, String login, String password, String email, boolean enabled,
//            Set<UserRole> userRole) {
//        enabled = this.enabled;
//        id_user = this.id_user;
//        login = this.login;
//        password = this.password;
//        email = this.email;
////        userRole = this.userRole;
//        userRole.add(
//                new UserRole(
//                       this, "user"
//                ));
//
//    }
//    
//    
//
//
//    public int getId_user() {
//        return id_user;
//    }
//
//    public void setId_user(int id_user) {
//        this.id_user = id_user;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public boolean isEnabled() {
//        return this.enabled;
//    }
//
//    public void setEnabled(boolean enabled) {
//        this.enabled = enabled;
//    }
//
//    public Set<UserRole> getUserRole() {
//        return userRole;
//    }
//
//    public void setUserRole(Set<UserRole> userRole) {
//        this.userRole = userRole;
//    }
//
//}

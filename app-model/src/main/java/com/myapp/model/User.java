package com.myapp.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	private String login;
	private String password;
	private String email;
	
	public User (){}
	public User (int id_user, String login, String password, String email){
		id_user = this.id_user;
		login = this.login;
		password = this.password;
		email = this.email;
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
	
	@Override
	public String toString(){
		return "id_user = " + id_user + ", login = " + login + ", password = "
				+ password + ", email = " + email;
	}
	
}

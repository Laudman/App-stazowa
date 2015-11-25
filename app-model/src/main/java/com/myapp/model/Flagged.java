package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="FLAGGEDS")
public class Flagged {
	private int id_user;
	private int id_task;
	private int id_answer;
	private boolean flag;
	private String comment;
	
	public Flagged ( int id_user, int id_task, int id_answer, boolean flag, String comment){
		id_user = this.id_user;
		id_task = this.id_task;
		id_answer = this.id_answer;
		flag = this.flag;
		comment = this.comment;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public int getId_task() {
		return id_task;
	}
	public void setId_task(int id_task) {
		this.id_task = id_task;
	}
	public int getId_answer() {
		return id_answer;
	}
	public void setId_answer(int id_answer) {
		this.id_answer = id_answer;
	}
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	@Override
	public String toString(){
		return "id_user = " + id_user + "id_answer = " + id_answer + 
				"id_task = "+ id_task + "flag = " + flag + id_task + "comment = " + comment;
	}

}

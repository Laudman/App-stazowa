package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="VOTES")
public class Vote {

	private int id_user;
	private int id_task;
	private int id_answer;
	private int vote;
	
	public Vote (int id_user, int id_task, int id_answer, int vote){
		id_user = this.id_user;
		id_task = this.id_task;
		id_answer = this.id_answer;
		vote = this.vote;
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
	public int getVote() {
		return vote;
	}
	public void setVote(int vote) {
		this.vote = vote;
	}
	@Override
	public String toString(){
		return "id_user = " + id_user + "id_answer = " + id_answer + 
				"id_task = "+ id_task + "vote = " + vote;
	}
	
}

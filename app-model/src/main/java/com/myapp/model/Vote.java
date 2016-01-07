package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_vote;
	private int id_user;
	private int id_task;
	private int id_answer;
	private int vote;
	
	public Vote(){}
	
	public Vote (int id_vote, int id_user, int id_task, int id_answer, int vote){
		id_vote = this.id_vote;
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


	public int getId_vote() {
		return id_vote;
	}


	public void setId_vote(int id_vote) {
		this.id_vote = id_vote;
	}
	
}

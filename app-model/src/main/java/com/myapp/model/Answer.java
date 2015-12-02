package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ANSWERS")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_answer;
	private int id_user;
	private int id_task;
	private String text_answer;
	
	public Answer(){}
	public Answer ( int id_answer, int id_user, int id_task, String text_answer){
		id_answer = this.id_answer;
		id_user = this.id_user;
		id_task = this.id_task;
		text_answer = this.text_answer;
	}
	public int getId_answer() {
		return id_answer;
	}
	public void setId_answer(int id_answer) {
		this.id_answer = id_answer;
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
	public String getText_answer() {
		return text_answer;
	}
	public void setText_answer(String text_answer) {
		this.text_answer = text_answer;
	}
	
	@Override
	public String toString(){
		return "id_answer = " + id_answer + "id_user = " + id_user +
				"id_task = " + id_task + "text_answer = " + text_answer;
	}
	

}

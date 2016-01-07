package com.myapp.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_task;
	private String text;
	private Long id_user;
	private String type_of_question;
	private String type_of_speak;
	private String type_of_job;
	private int amount_answer;
	
	public Task ( Long id_task, String text, Long id_user, String type_of_question, 
				  String type_of_speak, String type_of_job, int amount_answer){
		id_task = this.id_task;
		text = this.text;
		id_user = this.id_user;
		type_of_question = this.type_of_question;
		type_of_speak = this.type_of_speak;
		type_of_job = this.type_of_job;
		amount_answer = this.amount_answer;
	}
	public Long getId_task() {
		return id_task;
	}
	public void setId_task(Long id_task) {
		this.id_task = id_task;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public String getType_of_question() {
		return type_of_question;
	}
	public void setType_of_question(String type_of_question) {
		this.type_of_question = type_of_question;
	}
	public String getType_of_speak() {
		return type_of_speak;
	}
	public void setType_of_speak(String type_of_speak) {
		this.type_of_speak = type_of_speak;
	}
	public String getType_of_job() {
		return type_of_job;
	}
	public void setType_of_job(String type_of_job) {
		this.type_of_job = type_of_job;
	}
	public int getAmount_answer() {
		return amount_answer;
	}
	public void setAmount_answer(int amount_answer) {
		this.amount_answer = amount_answer;
	}
	
	@Override
	public String toString(){
		return "id_task = " + id_task + ", text = " + text + ", id_user = "
				+ id_user + ", type_of_question = " + type_of_question + 
				", type_of_speak = " + type_of_speak + ", type_of_job = " 
				+ type_of_job + ", amount_answer = " + amount_answer;
	}
	

}

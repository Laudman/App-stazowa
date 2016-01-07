package com.myapp.model;

import java.io.Serializable;
import javax.persistence.Column;
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
        @Column (name = "type_of_question")
	private int typeOfQuestion;
        @Column (name = "type_of_speak")
	private int typeOfSpeak;
        @Column (name = "type_of_job")
	private int typeOfJob;
        @Column (name = "amount_answer")
	private int amountAnswer;
        
	public Task() {}
        
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
	public int getTypeOfQuestion() {
		return typeOfQuestion;
	}
	public void setTypeOfQuestion(int typeOfQuestion) {
		this.typeOfQuestion = typeOfQuestion;
	}
	public int getTypeOfSpeak() {
		return typeOfSpeak;
	}
	public void setTypeOfSpeak(int typeOfSpeak) {
		this.typeOfSpeak = typeOfSpeak;
	}
	public int getTypeOfJob() {
		return typeOfJob;
	}
	public void setTypeOfJob(int typeOfJob) {
		this.typeOfJob = typeOfJob;
	}
	public int getAmountAnswer() {
		return amountAnswer;
	}
	public void setAmountAnswer(int amountAnswer) {
		this.amountAnswer = amountAnswer;
	}
	

}

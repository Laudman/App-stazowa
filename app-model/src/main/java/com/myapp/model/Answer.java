package com.myapp.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="answers")
public class Answer implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_answer;
	private Long id_user;
	private Long id_task;
        @Column (name = "text_answer")
	private String textAnswer;
        @Column (name = "vote_answer_pkt")
        private Long voteAnswerPkt;
	
	public Answer(){}
        
        public Long getVoteAnswerPkt(){
            return voteAnswerPkt;
        }
        public void setVoteAnswerPkt(Long voteAnswerPkt){
            this.voteAnswerPkt = voteAnswerPkt;
        }
	public Long getId_answer() {
		return id_answer;
	}
	public void setId_answer(Long id_answer) {
		this.id_answer = id_answer;
	}
	public Long getId_user() {
		return id_user;
	}
	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}
	public Long getId_task() {
		return id_task;
	}
	public void setId_task(Long id_task) {
		this.id_task = id_task;
	}
	public String getTextAnswer() {
		return textAnswer;
	}
	public void setTextAnswer(String textAnswer) {
		this.textAnswer = textAnswer;
	}

	

}

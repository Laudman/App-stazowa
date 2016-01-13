package com.myapp.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="votes")
public class Vote implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id_vote;
	private Long id_user;
	private Long id_task;
	private Long id_answer;
        @Column (name = "vote_pkt")
	private Long votePkt;
	
	public Vote(){}
	
        
	public Long getId_vote() {
		return id_vote;
	}
	public void setId_vote(Long id_vote) {
		this.id_vote = id_vote;
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
	public Long getId_answer() {
		return id_answer;
	}
	public void setId_answer(Long id_answer) {
		this.id_answer = id_answer;
	}
	public Long getVotePkt() {
		return votePkt;
	}
	public void setVotePkt(Long votePkt) {
		this.votePkt = votePkt;
	}
	
}

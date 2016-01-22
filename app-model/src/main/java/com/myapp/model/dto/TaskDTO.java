package com.myapp.model.dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author zama
 */
public class TaskDTO implements Serializable{

    private Long id_task;
    private String text;
    private Long id_user;
    private int typeOfQuestion;
    private int typeOfSpeak;
    private int typeOfJob;
    private int amountAnswer;
    private Long voteTaskPkt;
    private Boolean subscribed;
    private Date addDate;

    public TaskDTO() {
    }
    
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
        }
        
        public Date getAddDate(){
            return addDate;
        }
        
    public Long getVoteTaskPkt() {
        return voteTaskPkt;
    }

    public void setVoteTaskPkt(Long voteTaskPkt) {
        this.voteTaskPkt = voteTaskPkt;
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

    public Boolean getSubscribed() {
        return subscribed;
    }

    public void setSubscribed(Boolean subscribed) {
        this.subscribed = subscribed;
    }

}

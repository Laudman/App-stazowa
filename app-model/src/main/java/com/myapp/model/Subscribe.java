package com.myapp.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author zama
 */
@Entity
@Table(name = "subscribes")
public class Subscribe implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_sub")
    private Long idSub;
    @Column (name = "id_user_subscribe")
    private Long idUserSubscribe;
   
    @ManyToOne
    @JoinColumn(name = "id_task", referencedColumnName = "id_task")
    private Task task;
    
    public Subscribe() {
    }
    
    
    public Long getIdSub() {
        return idSub;
    }

    public void setIdSub(Long idSub) {
        this.idSub = idSub;
    }
    
    public Long getIdUserSubscribe (){
        return idUserSubscribe;
    }
    
    public void setIdUserSubscribe (Long idUserSubscribe){
        this.idUserSubscribe = idUserSubscribe;
    }
    
    public Task getTask (){
        return task;
    }
    
    public void setIdTaskSubscribe (Task task){
        this.task = task;
    }
    
}

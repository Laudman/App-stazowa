
package com.myapp.model;

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
@Table(name = "informations")
public class Information implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id_inf")
    private Long idInformation;
    @Column (name = "text_information")
    private String textInformation;
    @Column (name = "id_task")
    private Long idTask;
    @Column (name = "is_read")
    private boolean isRead = false;
   
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
    
    public Information() {
    }
    
    public boolean getIsRead() {
        return isRead;
    }

    public void setTextInformation(String textInformation) {
        this.textInformation = textInformation;
    }
    
    public String getTextInformation() {
        return textInformation;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }
    
    public Long getIdInformation() {
        return idInformation;
    }

    public void setIdInformation(Long idInformation) {
        this.idInformation = idInformation;
    }
    
    public User getUser (){
        return user;
    }
    
    public void setIdUser (User user){
        this.user = user;
    }
    
}


package com.myapp.model.dto;

import com.myapp.model.User;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author zama
 */
public class InformationDTO implements Serializable{
    
    private Long idInformation;
    private String textInformation;
    private Long idTask;
    private boolean isRead = false;
    private Date addDate;
    private Long idUserInfo;
    private User user;
    
    public InformationDTO() {
    }
    
    public void setIdUserInfo(Long idUserInfo) {
        this.idUserInfo = idUserInfo;
    }
    
    public Long getIdUserInfo() {
        return idUserInfo;
    }
    
    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }
        
    public Date getAddDate(){
        return addDate;
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


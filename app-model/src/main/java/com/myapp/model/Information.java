
package com.myapp.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author zama
 */

 @NamedNativeQueries({
	@NamedNativeQuery(
	name = "findMyInformations",
	query = "select * from informations where id = :id",
        resultClass = Information.class
	)
})

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
    @Column (name = "add_date")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date addDate;
    @Column (name = "id_user_inf")
    private Long idUserInfo;
   
   
    
    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;
    
    public Information() {
    }
    
     public Long getIdUserInfo() {
        return idUserInfo;
    }

    public void setIdUserInfo(Long idUserInfo) {
        this.idUserInfo = idUserInfo;
    }
    
    @PrePersist
        public void setAddDate() {
        this.addDate = new Date();
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

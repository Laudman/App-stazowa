package com.myapp.model.dto;

import java.io.Serializable;


/**
 *
 * @author zama
 */

public class SubscribeDTO implements Serializable{
    

    private Long idUserSubscribe;
    private Long idTask;
    
    public SubscribeDTO() {
    }
    
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }
    
    
    public Long getIdUserSubscribe (){
        return idUserSubscribe;
    }
    
    public void setIdUserSubscribe (Long idUserSubscribe){
        this.idUserSubscribe = idUserSubscribe;
    }
    
}

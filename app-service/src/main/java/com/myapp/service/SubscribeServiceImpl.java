
package com.myapp.service;

import com.myapp.dao.SubscribeDao;
import com.myapp.model.Subscribe;
import com.myapp.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zama
 */
@Service("subscribeService")
@Transactional
public class SubscribeServiceImpl implements SubscribeService{
    
    @Autowired
        private SubscribeDao subscribeDao;
    @Autowired
        private TaskService taskService;
    
    public Subscribe findSubscribe(Long idUserSubscribe){
        return subscribeDao.findSubscribe(idUserSubscribe);
    }
    
    public void saveSubscribe(Subscribe subscribe) {
        subscribeDao.saveSubscribe(subscribe);
    }

    public void deleteSubscribeBySession(Subscribe subscribe) {
        subscribeDao.deleteSubscribeBySession(subscribe);
    }

    public List<Subscribe> findAllSubscribes() {
        return subscribeDao.findAllSubscribes();
    }
    
    public Subscribe findSubscribeIncludeIdUserAndTask (Long idUserSubscribe, Task idTask){
        return subscribeDao.findSubscribeIncludeIdUserAndTask(idUserSubscribe, idTask);
    }
    public void deleteSubscribeById(Long id_sub){
        subscribeDao.deleteSubscribeById(id_sub);
    }
    public void deleteSubscribe ( Long idTask, Long idUser ){
   
           Task currentTask = taskService.findTask(idTask);
           Subscribe currentSub = subscribeDao.findSubscribeIncludeIdUserAndTask(idUser, currentTask); 
           deleteSubscribeById(currentSub.getIdSub());
          
        }
    public List<Long> findAllIdUsersSubscribedIdTask (Task idTask){
        return subscribeDao.findAllIdUsersSubscribedIdTask(idTask);
    }
    
    public List<Long> findAllSubscribesIdIncludedCurrentTaskId (Long idTask){
           return  subscribeDao.findAllSubscribesIdIncludedCurrentTaskId(idTask);
        }
    
    
}

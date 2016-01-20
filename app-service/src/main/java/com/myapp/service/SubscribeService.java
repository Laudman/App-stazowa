
package com.myapp.service;

import com.myapp.model.Subscribe;
import com.myapp.model.Task;
import java.util.List;

/**
 *
 * @author zama
 */
public interface SubscribeService {
    
    public Subscribe findSubscribe(Long idUserSubscribe);
    
    public void saveSubscribe(Subscribe subscribe);
    
    public void deleteSubscribeBySession(Subscribe subscribe);
    
    public List<Subscribe> findAllSubscribes();
    
    public Subscribe findSubscribeIncludeIdUserAndTask ( Long idUser, Task idTask);
    
    public void deleteSubscribe ( Long idTask, Long idUser );
    
    public void deleteSubscribeById(Long id_sub);
}

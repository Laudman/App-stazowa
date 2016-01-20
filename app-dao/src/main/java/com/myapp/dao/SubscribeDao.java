
package com.myapp.dao;

import com.myapp.model.Subscribe;
import com.myapp.model.Task;
import java.util.List;

/**
 *
 * @author zama
 */
public interface SubscribeDao {
    
    public Subscribe findSubscribe(Long idUserSubscribe);
    
    public void saveSubscribe(Subscribe subscribe);
    
    public void deleteSubscribeBySession(Subscribe subscribe);
    
    public List<Subscribe> findAllSubscribes();
    
    public Subscribe findSubscribeIncludeIdUserAndTask (Long id_user_subscribe, Task id_task);
    
    public void deleteSubscribeById(Long id_sub);
}

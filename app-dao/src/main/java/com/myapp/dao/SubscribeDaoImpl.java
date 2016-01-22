
package com.myapp.dao;

import com.myapp.model.Subscribe;
import com.myapp.model.Task;
import com.myapp.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.stereotype.Repository;

/**
 *
 * @author zama
 */
@Repository("subscribeDao")
public class SubscribeDaoImpl extends AbstractDao<Integer, Subscribe> implements SubscribeDao{
    
    
    public Subscribe findSubscribe(Long id_sub) {
		return getByKey(id_sub);
	}
    
    public void saveSubscribe(Subscribe subscribe) {
        save(subscribe);
    }

    public void deleteSubscribeBySession(Subscribe subscribe) {
        getSession().delete(subscribe);
    }
    
    public void deleteSubscribeById(Long id_sub) {

		Query query = getSession().createSQLQuery("delete from subscribes where id_sub = :id_sub");
		query.setParameter("id_sub", id_sub);
		query.executeUpdate();
	}

    public List<Subscribe> findAllSubscribes() {
        return getSession().createCriteria(Subscribe.class).list();
    }

    public Subscribe findSubscribeIncludeIdUserAndTask (Long id_user_subscribe, Task id_task){
        Criteria crit = getSession().createCriteria(Subscribe.class)
                .add(Restrictions.eq("idUserSubscribe", id_user_subscribe))
                .add(Restrictions.eq("task", id_task));
                 return (Subscribe) crit.uniqueResult();
    }
    
    public List<Long> findAllIdUsersSubscribedIdTask (Task id_task){
        Query query = getSession().createSQLQuery("select id_user_subscribe as num from subscribes where id_task = :id_task")
            .addScalar("num", StandardBasicTypes.LONG);
            query.setParameter("id_task", id_task);
            List <Long> allIdUsers = query.list();         
            return allIdUsers;
    }
    
    public List<Long> findAllSubscribesIdIncludedCurrentTaskId (Long id_task){
        Query query = getSession().createSQLQuery("select id_sub as num from subscribes where id_task = :id_task")
         .addScalar("num", StandardBasicTypes.LONG);
         query.setParameter("id_task", id_task);
         List <Long> answersIdByIdTask = query.list();         
         return answersIdByIdTask;
    }
}

package com.myapp.dao;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import com.myapp.model.Task;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao{
	public Task findTask(Long id_task) {
		return getByKey(id_task);
	}
        
        public void updateTask (Task task){
            update(task);
        }
        
	public void saveTask(Task task) {
		save(task);
	}

	public void deleteTask(Long id_task) {

		Query query = getSession().createSQLQuery("delete from Tasks where id_task = :id_task");
		query.setParameter("id_task", id_task);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria();
		return (List<Task>) criteria.list();
	}
   
        public List<Task> findTasksWithSubscribes(Long id_user) {
        Criteria crit = getSession().createCriteria(Task.class)
                .createAlias("sub", "subs")
                .add(Restrictions.eq("subs.idUserSubscribe", id_user));
        return crit.list();
    }
}

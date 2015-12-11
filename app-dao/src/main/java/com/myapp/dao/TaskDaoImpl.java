package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import com.myapp.model.Task;
import org.springframework.stereotype.Repository;

@Repository("taskDao")
public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao{
	public Task findTask(int id_task) {
		return getByKey(id_task);
	}

	public void saveOrUpdateTask(Task task) {
		persist(task);
	}

	public void deleteTask(int id_task) {

		Query query = getSession().createSQLQuery("delete from Tasks where id_task = :id_task");
		query.setParameter("id_task", id_task);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria();
		return (List<Task>) criteria.list();
	}
}

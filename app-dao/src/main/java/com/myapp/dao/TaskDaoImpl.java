package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;

import com.myapp.model.Task;

public class TaskDaoImpl extends AbstractDao<Integer, Task> implements TaskDao{
	public Task findTask(int id) {
		return getByKey(id);
	}

	public void saveOrUpdateTask(Task task) {
		persist(task);
	}

	public void deleteTask(int id) {

		Query query = getSession().createSQLQuery("delete from User where id = :id_task");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Task> findAllTasks() {
		Criteria criteria = createEntityCriteria();
		return (List<Task>) criteria.list();
	}
}

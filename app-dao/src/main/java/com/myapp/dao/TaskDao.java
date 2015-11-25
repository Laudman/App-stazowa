package com.myapp.dao;

import java.util.List;

import com.myapp.model.Task;

public interface TaskDao {
	Task findTask(int id);

	void saveOrUpdateTask(Task task);
	
	void deleteTask(int id);
	
	List<Task> findAllTasks();
}

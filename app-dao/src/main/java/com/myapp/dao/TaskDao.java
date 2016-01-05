package com.myapp.dao;

import java.util.List;

import com.myapp.model.Task;

public interface TaskDao {
	Task findTask(Long id);

	void saveTask(Task task);
	
	void deleteTask(Long id);
	
	List<Task> findAllTasks();
}

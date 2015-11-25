package com.myapp.service;

import java.util.List;

import com.myapp.model.Task;

public interface TaskService {

	Task findTask(int id);

	void saveOrUpdateTask(Task task);
	
	void deleteTask(int id);
	
	List<Task> findAllTasks();
}

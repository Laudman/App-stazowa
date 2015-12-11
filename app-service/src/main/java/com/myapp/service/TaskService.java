package com.myapp.service;

import java.util.List;

import com.myapp.model.Task;

public interface TaskService {

	Task findTask(int id_task);

	void saveOrUpdateTask(Task task);
	
	void deleteTask(int id_task);
        
        void updateTask (Task task);
	
	List<Task> findAllTasks();
}

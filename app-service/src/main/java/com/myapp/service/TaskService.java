package com.myapp.service;

import java.util.List;

import com.myapp.model.Task;

public interface TaskService {

	Task findTask(Long id_task);

	void saveTask(Task task);
	
	void deleteTask(Long id_task);
        
        void updateTask (Task task);
	
	List<Task> findAllTasks();
}

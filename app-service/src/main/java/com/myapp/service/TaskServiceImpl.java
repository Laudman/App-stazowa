package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.TaskDao;
import com.myapp.model.Task;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskdao;
        
        private static List<Task> tasks;
	
	public Task findTask(Long id_task) {
		return taskdao.findTask(id_task);
	}

	public void saveTask(Task task) {
		taskdao.saveTask(task);
	}
	
	public void updateTask(Task task) {
		Task entity = taskdao.findTask(task.getId_task());
		if(entity!=null){
			entity.setText(task.getText());
			entity.setTypeOfQuestion(task.getTypeOfQuestion());
			entity.setTypeOfSpeak(task.getTypeOfSpeak());
			entity.setTypeOfJob(task.getTypeOfJob());
			entity.setAmountAnswer(task.getAmountAnswer());
		}
	}

	public void deleteTask(Long id_task) {
		taskdao.deleteTask(id_task);
	}

	public List<Task> findAllTasks() {
		return taskdao.findAllTasks();
	}

}

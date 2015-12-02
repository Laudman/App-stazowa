package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.TaskDao;
import com.myapp.model.Task;

//@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao dao;
	
	public Task findTask(int id) {
		return dao.findTask(id);
	}

	public void saveOrUpdateTask(Task task) {
		dao.saveOrUpdateTask(task);
	}
	
	public void updateUser(Task task) {
		Task entity = dao.findTask(task.getId_user());
		if(entity!=null){
			entity.setText(task.getText());
			entity.setType_of_question(task.getType_of_question());
			entity.setType_of_speak(task.getType_of_speak());
			entity.setType_of_job(task.getType_of_job());
			entity.setAmount_answer(task.getAmount_answer());
		}
	}

	public void deleteTask(int id) {
		dao.deleteTask(id);
	}

	public List<Task> findAllTasks() {
		return dao.findAllTasks();
	}

}

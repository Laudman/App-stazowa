package com.myapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.TaskDao;
import com.myapp.model.Subscribe;
import com.myapp.model.Task;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService{
	
	@Autowired
	private TaskDao taskDao;
        
        private static List<Task> tasks;
	
	public Task findTask(Long id_task) {
		return taskDao.findTask(id_task);
	}

	public void saveTask(Task task) {
		taskDao.saveTask(task);
	}
	
	public void updateTask(Task task) {
		taskDao.updateTask (task);
	}

	public void deleteTask(Long id_task) {
		taskDao.deleteTask(id_task);
	}

	public List<Task> findAllTasks() {
		return taskDao.findAllTasks();
	}
        
        public List<Task> findTasksWithSubscribes(Long id_user){
            return taskDao.findTasksWithSubscribes(id_user);
        }
        
        public void updateTaskWithNewSubscribe (Long idTask, Long idUser){
           Task currentTask = findTask(idTask);
           Subscribe s = new Subscribe();
           s.setIdUserSubscribe(idUser);
           s.setIdTaskSubscribe(currentTask);
           
           currentTask.addSubscribe(s);
           saveTask(currentTask);
            
        }
        
                

}

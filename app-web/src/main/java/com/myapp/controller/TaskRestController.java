package com.myapp.controller;

import com.myapp.model.Task;
import com.myapp.model.dto.TaskDTO;
import com.myapp.model.dto.TaskMapper;
import com.myapp.model.global.Globals;
import com.myapp.service.TaskService;
import com.myapp.service.VoteService;
import com.myapp.service.AnswerService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TaskRestController {
    
    @Autowired
        private TaskService taskService;
    @Autowired
        private VoteService voteService;
    @Autowired
        private AnswerService answerService;
    
    @ResponseBody
    @RequestMapping(value = "/tasks/guest", method = RequestMethod.GET)
    public  List<TaskDTO> listAllTasksGuest()  { 
        return TaskMapper.map(taskService.findAllTasks());        
    }
    
    @ResponseBody
    @RequestMapping(value = "/tasks/{id_user}", method = RequestMethod.GET)
    public  List<TaskDTO> listAllTasks(@PathVariable("id_user") Long id_user)  { 
            Globals idCurrentUser = new Globals();
            idCurrentUser.setIdCurrentUser(id_user);
        return TaskMapper.map(taskService.findAllTasks());        
    }
    
    @ResponseBody
    @RequestMapping(value = "/tasks/submited/{id_user}", method = RequestMethod.GET)
    public  List<TaskDTO> listMyTasks(@PathVariable("id_user") Long id_user)  { 
            return TaskMapper.map(taskService.findTasksWithSubscribes(id_user));   
    } 
    
    @ResponseBody
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody Task task) throws Exception {

        taskService.saveTask(task);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tasks/task/{id_task}", method = RequestMethod.GET)
    public  ResponseEntity<Task> getTask(@PathVariable("id_task") Long id_task) {
   
        Task task = taskService.findTask(id_task);
        if (task == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Task>(task, HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tasks/update", method = RequestMethod.POST)
    public ResponseEntity<Task> updateUser(@RequestBody Task taskJSON) {

        Task currentTask = taskService.findTask(taskJSON.getId_task());


        if (currentTask == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        currentTask.setTypeOfJob(taskJSON.getTypeOfJob());
        currentTask.setTypeOfQuestion(taskJSON.getTypeOfQuestion());
        currentTask.setTypeOfSpeak(taskJSON.getTypeOfSpeak());
        currentTask.setText(taskJSON.getText());
        currentTask.setAmountAnswer(taskJSON.getAmountAnswer());

        taskService.saveTask(currentTask);
        return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = "/tasks/delete", method = RequestMethod.POST)
    public ResponseEntity<Task> deleteTask(@RequestBody Task taskJSON) {
 
        Task task = taskService.findTask(taskJSON.getId_task());
        if (task == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        
        ArrayList<Long> listIdAnswers = new ArrayList<Long>();
        listIdAnswers.addAll(answerService.findAllAnswersIdIncludedCurrentTaskId (taskJSON.getId_task()));
        for (Long listIdAnswer : listIdAnswers) {
            voteService.deleteAllVotesIncludedIdAnswer (listIdAnswer);
        }
        
        ArrayList<Long> listIdSubscribes = new ArrayList<Long>();
        listIdAnswers.addAll(answerService.findAllAnswersIdIncludedCurrentTaskId (taskJSON.getId_task()));
        for (Long listIdSubscribe : listIdSubscribes) {
            voteService.deleteAllVotesIncludedIdAnswer (listIdSubscribe);
        }
        
        answerService.deleteAllAnswersIncludedIdTask(taskJSON.getId_task());
        taskService.deleteTask(taskJSON.getId_task());
        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
    
    }
    
}
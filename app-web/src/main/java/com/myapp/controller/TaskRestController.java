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
    
    
    
    
    
    
    
    
    
    
    
    
    
//    //---------------------Show All Tasks-----------------------
//     @Produces("application/json")
//	@ResponseBody
//	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
//    public  List<Task>listAllTasks() {
//        return taskService.findAllTasks();
//        
//    }
//    
//    //-------------------Retrieve Single Task ----------------------------------
//    @Produces("application/json")
//    @ResponseBody
//    @RequestMapping(value = "/tasks/{id_task}", method = RequestMethod.GET)
//    public  ResponseEntity<Task> getTask(@PathVariable("id_task") Long id_task) {
//        System.out.println("Fetching Task with id " + id_task);
//        Task task = taskService.findTask(id_task);
//        if (task == null) {
//            System.out.println("Task with id_task " + id_task + " not found");
//            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<Task>(task, HttpStatus.OK);
//    }
//    
//    // -------------------Create Task--------------------------------------------------------
//    @Produces("application/json")
//    @ResponseBody
//    @RequestMapping(value = "/tasks", method = RequestMethod.POST )
//    public  ResponseEntity<Task> addTask(@RequestBody Task task, UriComponentsBuilder ucBuilder) {
//        System.out.println("Creating Task " + task.getText());
//
//        taskService.saveTask(task);
// 
//        HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(ucBuilder.path("/tasks/{id_task}").buildAndExpand(task.getId_task()).toUri());
//        return new ResponseEntity<Task>(headers, HttpStatus.CREATED);
//    }
//    
//    //------------------- Update Task --------------------------------------------------------
//    @Produces("application/json")
//    @ResponseBody
//    @RequestMapping(value = "/tasks/update", method = RequestMethod.POST)
//    public ResponseEntity<Task> updateTask(@RequestBody Task taskJSON) {
//        System.out.println("Updating Task " + taskJSON.getId_task());
//         
//        Task currentTask = taskService.findTask(taskJSON.getId_task());
//         
//        if (currentTask == null) {
//            System.out.println("Task with id_task " + taskJSON.getId_task() + " not found");
//            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
//        }
// 
//        currentTask.setText(taskJSON.getText());
//        currentTask.setType_of_question(taskJSON.getType_of_question());
//        currentTask.setType_of_speak(taskJSON.getType_of_speak());
//        currentTask.setType_of_job(taskJSON.getType_of_job());
//        currentTask.setAmount_answer(taskJSON.getAmount_answer());
//        
//         
//        taskService.updateTask(currentTask);
//        return new ResponseEntity<Task>(currentTask, HttpStatus.OK);
//    }
//    
//    //------------------- Delete Task --------------------------------------------------------
//    @Produces("application/json")
//    @ResponseBody
//    @RequestMapping(value = "/tasks/delete", method = RequestMethod.POST)
//    public ResponseEntity<Task> deleteTask(@RequestBody Task taskJSON) {
//        System.out.println("Fetching & Deleting Task with id_task " + taskJSON.getId_task());
// 
//        Task task = taskService.findTask(taskJSON.getId_task());
//        if (task == null) {
//            System.out.println("Unable to delete. Task with id_task " + taskJSON.getId_task() + " not found");
//            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
//        }
// 
//        taskService.deleteTask(taskJSON.getId_task());
//        return new ResponseEntity<Task>(HttpStatus.NO_CONTENT);
//    }
//    
//    //***************************END TASK CONTROLLER*********************************************

//}
    
    
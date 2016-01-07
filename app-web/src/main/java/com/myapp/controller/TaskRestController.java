package com.myapp.controller;


import com.myapp.model.Task;
import com.myapp.service.TaskService;
import java.util.List;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class TaskRestController {
    
    @Autowired
        private TaskService taskService;
    
    
    @ResponseBody
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public ResponseEntity addTask(@RequestBody Task task) throws Exception {

        taskService.saveTask(task);

        return new ResponseEntity(HttpStatus.CREATED);
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

}
    
    
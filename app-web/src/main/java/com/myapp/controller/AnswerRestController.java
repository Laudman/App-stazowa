
package com.myapp.controller;

import com.myapp.model.Answer;
import com.myapp.model.Task;
import com.myapp.service.AnswerService;
import com.myapp.service.TaskService;
import com.myapp.service.VoteService;
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

/**
 *
 * @author zama
 */

@RestController
public class AnswerRestController {
    
    @Autowired
        private TaskService taskService;
    
    @Autowired
        private AnswerService answerService;
    @Autowired
        private VoteService voteService;
      
    @ResponseBody
    @RequestMapping(value = "/answers", method = RequestMethod.GET)
    public  List<Answer>listAllAnswers() {
        return answerService.findAllAnswers();
    }
    
    @ResponseBody
    @RequestMapping(value = "/answers/{id_answer}", method = RequestMethod.GET)
    public  ResponseEntity<Answer> getAnswer(@PathVariable("id_answer") Long id_answer) {
   
        Answer answer = answerService.findAnswer(id_answer);
        if (answer == null) {
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Answer>(answer, HttpStatus.OK);
    }
      
    @ResponseBody
    @RequestMapping(value = "/answers", method = RequestMethod.POST)
    public ResponseEntity addAnswer(@RequestBody Answer answer) throws Exception {

        Task currentTask = taskService.findTask(answer.getId_task());
        if (currentTask == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        int autoincrement = currentTask.getAmountAnswer();
        currentTask.setAmountAnswer(++autoincrement);
        taskService.saveTask(currentTask);
        
        answerService.saveAnswer(answer);
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @ResponseBody
    @RequestMapping(value = "/answers/update", method = RequestMethod.POST)
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answerJSON) {

        Answer currentAnswer = answerService.findAnswer(answerJSON.getId_answer());


        if (currentAnswer == null) {
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        currentAnswer.setTextAnswer(answerJSON.getTextAnswer());

        answerService.saveAnswer(currentAnswer);
        return new ResponseEntity<Answer>(currentAnswer, HttpStatus.OK);
    }
    
   
    @ResponseBody
    @RequestMapping(value = "/answers/delete", method = RequestMethod.POST)
    public ResponseEntity deleteAnswer(@RequestBody Answer answerJSON) {
 
        Answer answer = answerService.findAnswer(answerJSON.getId_answer());
        if (answer == null) {
            return new ResponseEntity<Answer>(HttpStatus.NOT_FOUND);
        }
        
        Task currentTask = taskService.findTask(answer.getId_task());
        if (currentTask == null) {
            return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
        }
        int autoincrement = currentTask.getAmountAnswer();
        currentTask.setAmountAnswer(--autoincrement);
        taskService.saveTask(currentTask);
 
        voteService.deleteAllVotesIncludedIdAnswer(answerJSON.getId_answer());
        answerService.deleteAnswerBySession(answerJSON);
        return new ResponseEntity<Answer>(HttpStatus.NO_CONTENT);
    }
    
}

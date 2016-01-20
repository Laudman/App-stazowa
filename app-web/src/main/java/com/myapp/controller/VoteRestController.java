package com.myapp.controller;

import com.myapp.model.Answer;
import com.myapp.model.Task;
import com.myapp.model.Vote;
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
public class VoteRestController {
    @Autowired
        private VoteService voteService;
    @Autowired
        private AnswerService answerService;
    @Autowired
        private TaskService taskService;
  
      
    @ResponseBody
    @RequestMapping(value = "/votes", method = RequestMethod.GET)
    public  List<Vote>listAllVotes() {
        return voteService.findAllVotes();
    }
    
           @ResponseBody
    @RequestMapping(value = "/votes/{id_answer}", method = RequestMethod.GET)
    public  ResponseEntity<Vote> getVote(@PathVariable("id_vote") Long id_vote) {
   
        Vote vote = voteService.findVote(id_vote);
        if (vote == null) {
            return new ResponseEntity<Vote>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vote>(vote, HttpStatus.OK);
    }
      
    @ResponseBody
    @RequestMapping(value = "/votes", method = RequestMethod.POST)
    public ResponseEntity addVote(@RequestBody Vote voteJSON) throws Exception { 
        
       if(voteJSON.getId_task() == 0)  {
           
       if(voteService.addPkt(voteJSON) == 1){
           voteJSON.setVotePkt(1L);       
           voteService.saveVote(voteJSON);
           
           Answer answer = answerService.findAnswer(voteJSON.getId_answer());
           answer.setVoteAnswerPkt(voteService.amountPktInAnswer(voteJSON.getId_answer()));
           answerService.saveAnswer(answer);
           return new ResponseEntity(HttpStatus.CREATED);
       }
       if(voteService.addPkt(voteJSON) == 2){
           voteJSON.setVotePkt(-1L);
           voteService.saveVote(voteJSON);
           
           Answer answer = answerService.findAnswer(voteJSON.getId_answer());
           answer.setVoteAnswerPkt(voteService.amountPktInAnswer(voteJSON.getId_answer()));
           answerService.saveAnswer(answer);
           return new ResponseEntity(HttpStatus.CREATED); 
       }
       else{
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }      
       }
       
       if(voteJSON.getId_answer() == 0)  {
           if(voteService.addPkt(voteJSON) == 1){
           voteJSON.setVotePkt(1L);       
           voteService.saveVote(voteJSON);
           
           Task task = taskService.findTask(voteJSON.getId_task());
           task.setVoteTaskPkt(voteService.amountPktInTask(voteJSON.getId_task()));
           taskService.saveTask(task);
           return new ResponseEntity(HttpStatus.CREATED);
       }
       if(voteService.addPkt(voteJSON) == 2){
           voteJSON.setVotePkt(-1L);
           voteService.saveVote(voteJSON);
           
           Task task = taskService.findTask(voteJSON.getId_task());
           task.setVoteTaskPkt(voteService.amountPktInTask(voteJSON.getId_task()));
           taskService.saveTask(task);
           return new ResponseEntity(HttpStatus.CREATED); 
       }
       else{
           return new ResponseEntity(HttpStatus.NOT_FOUND);
       }      
       }
      
       return new ResponseEntity(HttpStatus.CREATED);
       
}
}
        


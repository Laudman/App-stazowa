package com.myapp.controller;

import com.myapp.model.Subscribe;
import com.myapp.model.dto.SubscribeDTO;
import com.myapp.service.SubscribeService;
import com.myapp.service.TaskService;
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
public class SubscribeRestController {
    @Autowired
        private SubscribeService subscribeService;
    @Autowired
        private TaskService taskService;
    
    @ResponseBody
    @RequestMapping(value = "/subscribes", method = RequestMethod.GET)
    public  List<Subscribe>listAllSubscribes() {
        return subscribeService.findAllSubscribes();
    }
    
    @ResponseBody
    @RequestMapping(value = "/subscribes/{idSub}", method = RequestMethod.GET)
    public  ResponseEntity<Subscribe> getSubscribe(@PathVariable("idSub") Long idSub) {
   
        Subscribe subscribe = subscribeService.findSubscribe(idSub);
        if (subscribe == null) {
            return new ResponseEntity<Subscribe>(HttpStatus.NOT_FOUND);
        }
        subscribeService.deleteSubscribeBySession(subscribe);
        return new ResponseEntity<Subscribe>(subscribe, HttpStatus.OK);
    }
    
    @ResponseBody
    @RequestMapping(value = "/subscribes", method = RequestMethod.POST)
    public ResponseEntity addSubscribe(@RequestBody SubscribeDTO subscribeJSON) throws Exception { 
        
        taskService.updateTaskWithNewSubscribe (subscribeJSON.getIdTask(), subscribeJSON.getIdUserSubscribe());
       
        return new ResponseEntity(HttpStatus.CREATED);
    }
    
    @ResponseBody
    @RequestMapping(value = "/subscribes/delete", method = RequestMethod.POST)
    public ResponseEntity<Subscribe> deleteSubscribe(@RequestBody SubscribeDTO subscribeJSON) {
        
       subscribeService.deleteSubscribe (subscribeJSON.getIdTask(), subscribeJSON.getIdUserSubscribe());

        return new ResponseEntity<Subscribe>( HttpStatus.OK);
    }
   
    
}

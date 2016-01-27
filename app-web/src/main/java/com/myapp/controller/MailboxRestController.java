
package com.myapp.controller;

import com.myapp.model.Information;
import com.myapp.model.dto.InformationDTO;
import com.myapp.model.dto.InformationMapper;
import com.myapp.model.global.Globals;
import com.myapp.service.InformationService;
import com.myapp.service.UserService;
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
public class MailboxRestController {
    
    @Autowired
        private InformationService informationService;
    @Autowired
        private UserService userService;
    
    @ResponseBody
    @RequestMapping(value = "/informations/{id_user}", method = RequestMethod.GET)
    public  List<InformationDTO>listMyInformations(@PathVariable("id_user") Long id_user) {
      
        return InformationMapper.map(informationService.findMyInformations(id_user)); 
    }
    
    
    @ResponseBody
    @RequestMapping(value = "/informations/delete", method = RequestMethod.POST)
    public ResponseEntity<Information> deleteSubscribe(@RequestBody Information informationJSON) {
        
       informationService.deleteInformationById(informationJSON.getIdInformation());

        return new ResponseEntity<Information>( HttpStatus.OK);
    }
   
}

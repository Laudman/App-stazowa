
package com.myapp.service;

import com.myapp.dao.InformationDao;
import com.myapp.model.Information;
import com.myapp.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zama
 */
@Service("informationService")
@Transactional
public class InformationServiceImpl implements InformationService{
    
    @Autowired
        private InformationDao informationDao;
    @Autowired
        private UserService userService;
    
    public Information findInformation(Long idInformation) {
		return informationDao.findInformation(idInformation);
	}
    
    public void saveInformation(Information information) {
        informationDao.saveInformation(information);
    }

    public void deleteInformationBySession(Information information) {
        informationDao.deleteInformationBySession(information);
    }
    
    public void deleteInformationById(Long idInformation) {
	informationDao.deleteInformationById(idInformation);
    }

    public List<Information> findAllInformations() {
        return informationDao.findAllInformations();
    }
    
    public Information findInformationsIncludeIdTaskAndUser (Long idTask, User idUser){
        return informationDao.findInformationsIncludeIdTaskAndUser(idTask, idUser);
    }
    
    public void deleteInformation ( Long idTask, Long idUser ){
   
           User currentUser = userService.findUser(idUser);
           Information currentInf = informationDao.findInformationsIncludeIdTaskAndUser(idTask, currentUser); 
           deleteInformationById(currentInf.getIdInformation());
          
        }
    
    public List<Information> findMyInformations(Long id){
       return informationDao.findMyInformations(id);
    }
}

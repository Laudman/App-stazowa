/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.dao;

import com.myapp.model.Information;
import com.myapp.model.User;
import java.util.List;

/**
 *
 * @author zama
 */
public interface InformationDao {
    
    public Information findInformation(Long idInformation);
    
    public void saveInformation(Information information);
    
    public void deleteInformationBySession(Information information);
    
    public List<Information> findAllInformations();
    
    public Information findInformationsIncludeIdTaskAndUser (Long idTask, User idUser);
    
    public void deleteInformationById(Long idInformation);
}

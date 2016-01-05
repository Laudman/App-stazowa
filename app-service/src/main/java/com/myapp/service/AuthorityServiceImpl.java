/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.dao.AuthorityDao;
import com.myapp.model.Authority;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author zama
 */
@Service("userProfileService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService{
    @Autowired
    AuthorityDao dao;
     
    public Authority findById(Long id) {
        return dao.findById(id);
    }
 
    public Authority findByType(String type){
        return dao.findByType(type);
    }
 
    public List<Authority> findAll() {
        return dao.findAll();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myapp.dao.RoleDAO;

/**
 *
 * @author zama
 */

@Service
@Transactional
public class RoleServiceImpl {
    @Autowired
    private RoleDAO roleDAO;
 
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }
}

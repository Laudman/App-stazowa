/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.service;

import com.myapp.model.Authority;
import java.util.List;

/**
 *
 * @author zama
 */
public interface AuthorityService {
    Authority findById(Long id);
 
    Authority findByType(String type);
     
    List<Authority> findAll();
}

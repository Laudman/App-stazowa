package com.myapp.dao;

import com.myapp.model.Authority;
import java.util.List;

/**
 *
 * @author zama
 */
public interface AuthorityDao {
    List<Authority> findAll();
     
    Authority findByType(String type);
     
    Authority findById(Long id);
}


package com.myapp.dao;

import com.myapp.model.Authority;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorityDaoImpl extends AbstractDao<Integer, Authority> implements AuthorityDao {

    public Authority findById(Long id) {
        return getByKey(id);
    }

    public Authority findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Authority) crit.uniqueResult();
    }

    @SuppressWarnings("unchecked")
    public List<Authority> findAll() {
        Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("type"));
        return (List<Authority>) crit.list();
    }
}

package com.myapp.dao;

import com.myapp.model.User;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends AbstractDao<Long, User> implements UserDao {

    public User findUserByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        User user = (User) crit.uniqueResult();
        if (user != null) {
            Hibernate.initialize(user.getAuthority());
        }
        return user;
    }
    
    public void saveUser(User user) {
        if (user.getId() != null){
            merge(user);
            
        }else {
            save(user);
        }
    }    
   
    public void updateUser (User user){
        update (user);
    }
    
//    public List<User> findAllUsers() {
//        return getSession().createCriteria(User.class).list();
//    }
//    public List<User> findAllUsers() {
//        Query query = getSession().createSQLQuery("select * from users");
//        List <User> users = query.list();         
//            return users;
//    }
    public List<User> findAllUsers() {
        Query query = getSession().getNamedQuery("users");
        return query.list();
    }

    public void deleteUserByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        User user = (User) crit.uniqueResult();
        delete(user);
    }

    public User findUser(Long id) {
        User user = getByKey(id);
        if (user != null) {
            Hibernate.initialize(user.getAuthority());
        }
        return user;
    }
    
    
    public void deleteUserById(Long id) {
        Query query = getSession().createSQLQuery("delete from Users where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
    public void deleteUserBySession(User user) {
        getSession().delete(user);
    }
   

}

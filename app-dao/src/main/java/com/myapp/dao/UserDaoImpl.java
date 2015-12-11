package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.myapp.model.User;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
//	public User findUser(int id_user) {
//		return getByKey(id_user);
//	}
        
        public User findUser(int id) {
        User user = getByKey(id);
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }

        public User findUserByLogin(String login) {
       // System.out.println("Login : "+login);
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("LoginId", login));
        User user = (User)crit.uniqueResult();
        if(user!=null){
            Hibernate.initialize(user.getUserProfiles());
        }
        return user;
    }


	public void saveUser(User user) {
		persist(user);
	}
        
//        public void updateUser(User user){
//            update (user);
//        }


	public void deleteUser(int id_user) {

		Query query = getSession().createSQLQuery("delete from Users where id_user = :id_user");
		query.setParameter("id_user", id_user);
		query.executeUpdate();
	}

//	@SuppressWarnings("unchecked")
//	public List<User> findAllUsers() {
//		Criteria criteria = createEntityCriteria();
//		return (List<User>) criteria.list();
//	}
         @SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = createEntityCriteria().addOrder(Order.asc("login"));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid duplicates.
        List<User> users = (List<User>) criteria.list();
        
        return users;
    }

     public void deleteUserByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        User user = (User)crit.uniqueResult();
        delete(user);
    }


}

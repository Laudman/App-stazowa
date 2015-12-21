package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import com.myapp.model.User;
import javax.transaction.Transactional;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
//	public User findUser(int id_user) {
//		return getByKey(id_user);
//	}
        
        public User findUser(int id_user) {
        User user = getByKey(id_user);
        if(user!=null){
            Hibernate.initialize(user.getUserRole());
        }
        return user;
    }
//        @Transactional
//        @SuppressWarnings("unchecked")
//        public User findUserByLogin(String login) {
//       // System.out.println("Login : "+login);
//        Criteria crit = createEntityCriteria();
//        crit.add(Restrictions.eq("login", login));
//        User user = (User)crit.uniqueResult();
//        if(user!=null){
//            Hibernate.initialize(user.getUserRole());
//        }
//        return user;
//    }
        
        @Override
    //@Transactional
    @SuppressWarnings("unchecked")
    public User findUserByLogin(String login){
        String query = "from User where login = ?";
        List<User> listUser = sessionFactory.getCurrentSession().createQuery(query).setParameter(0, login).list();

        if(listUser.size() > 0)
            return listUser.get(0);
        else
            return null;
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
        return getSession().createCriteria(User.class).addOrder(Order.asc("login")).list();
    }

     public void deleteUserByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        User user = (User)crit.uniqueResult();
        delete(user);
    }

   


}

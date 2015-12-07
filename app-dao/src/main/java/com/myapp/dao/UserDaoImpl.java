package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myapp.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
	public User findUser(int id_user) {
		return getByKey(id_user);
	}

	public void saveOrUpdateUser(User user) {
		persist(user);
	}

	public void deleteUser(int id_user) {

		Query query = getSession().createSQLQuery("delete from User where id_user = :id_user");
		query.setParameter("id_user", id_user);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}




}

package com.myapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.myapp.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao{
	
	public User findUser(int id) {
		return getByKey(id);
	}

	public void saveOrUpdateUser(User user) {
		persist(user);
	}

	public void deleteUser(int id) {

		Query query = getSession().createSQLQuery("delete from User where id = :id_user");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria();
		return (List<User>) criteria.list();
	}




}

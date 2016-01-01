package com.interlan.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.interlan.dao.UserDao;
import com.interlan.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory session;
	
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		session.getCurrentSession().save(user);
	}

	@Override
	public void editUser(User user) {
		// TODO Auto-generated method stub
		session.getCurrentSession().update(user);
	}

	@Override
	public void deleteUser(int userId) {
		// TODO Auto-generated method stub
		session.getCurrentSession().delete(findUserById(userId));
	}

	@Override
	public User findUserById(int userId) {
		// TODO Auto-generated method stub
		return (User)session.getCurrentSession().get(User.class, userId);
	}

	@Override
	public User findUserByName(String userName) {
		// TODO Auto-generated method stub
		Criteria criteria = session.getCurrentSession().createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));
		return (User)criteria.uniqueResult();
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return session.getCurrentSession().createQuery("from User").list();
	}

}

package com.uxpsystems.assignment.dao;


import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uxpsystems.assignment.model.User;
 
@Repository
@Transactional
public class UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	
	public List<User> getAllUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User>  userList = session.createQuery("from User").list();
		return userList;
	}
 
	public User getUserById(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.get(User.class, id);
		return user;
	}
 
	public User createUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
		return user;
	}
 
	public void updateUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
	}
 
	public void deleteUser(Long id) {
		Session session = this.sessionFactory.getCurrentSession();
		User p = (User) session.load(User.class, id);
		if (null != p) {
			session.delete(p);
		}
	} 
	
	
}

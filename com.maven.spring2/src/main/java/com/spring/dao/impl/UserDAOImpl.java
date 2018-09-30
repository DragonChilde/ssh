package com.spring.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;


import com.spring.dao.UserDAO;
import com.spring.model.User;

@Component("u")
public class UserDAOImpl implements UserDAO {
	
	private List<String> lists;
	//private DataSource dataSource;
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<String> getLists() {
		return lists;
	}

	public void setLists(List<String> lists) {
		this.lists = lists;
	}

	@Override
	public void save(User user) {
		Session session = sessionFactory.getCurrentSession();
		//session.beginTransaction();
		session.save(user);
		//session.getTransaction().commit();
		
		//throw new RuntimeException("error!");
		
		System.out.println("user saved");
		//throw new RuntimeException("exeption!");
		
	}

	@Override
	public void delete() {
		// TODO �Զ����ɵķ������
		
	}

	
}

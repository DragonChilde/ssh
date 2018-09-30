package com.spring.service;



import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.spring.dao.LogsDAO;
import com.spring.dao.UserDAO;
import com.spring.model.Logs;
import com.spring.model.User;

@Component("userService")
public class UserService {
	
	private LogsDAO logsDAO;

	private UserDAO userDAO;

	@Transactional
	public void add(User user)
	{
		userDAO.save(user);
		Logs logs = new Logs();
		logs.setMsg("saved an mesage!");
		logsDAO.save(logs);
	}
	
	@PreDestroy
	public void destory()
	{
		System.out.println("destory");
	}
	
	public LogsDAO getLogsDAO() {
		return logsDAO;
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	@PostConstruct
	public void init()
	{
		System.out.println("init");
	}

/*	@Autowired
	public void setUserDAO(@Qualifier("u")UserDAO userDAO) {
		this.userDAO = userDAO;
	}*/
	
	 @Resource
	public void setLogsDAO(LogsDAO logsDAO) {
		this.logsDAO = logsDAO;
	}
	 
	 @Resource(name="u")
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
}

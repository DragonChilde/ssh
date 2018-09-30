package com.spring.dao;

import com.spring.model.User;

public interface UserDAO
{
	public void save(User user);
	
	public void delete();
}

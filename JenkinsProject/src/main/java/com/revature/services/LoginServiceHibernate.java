package com.revature.services;

import org.springframework.stereotype.Service;

import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.UserHibernate;

@Service
public class LoginServiceHibernate implements LoginService {
	
private UserDAO ud= new UserHibernate();

	@Override
	public User login(String username, String password) {
		return ud.getUser(username, password);
	}

	@Override
	public User register(User u) 
	{
		return ud.addUser(u);
	}

}

package com.revature.services;

import com.revature.beans.User;

public interface LoginService
{
	//Method to register a User
	public int register(User u);
		
    //Method signature to check a User's credentials
    public User login(String username, String password);

}


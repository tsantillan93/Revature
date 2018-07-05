package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.UserHibernate;

@Service
public class HomeServiceHibernate implements HomeService {
	private UserDAO ud= new UserHibernate();
	
	@Override
	public Set<Post> getAllPosts() 
	{

		return null;
	}

	@Override
	public void viewUserInfo(User u) 
	{
		ud.getUser(u);	
	}
	
	@Override
	public void updateUserInfo(User u) 
	{
		ud.updateUser(u);
	}

}

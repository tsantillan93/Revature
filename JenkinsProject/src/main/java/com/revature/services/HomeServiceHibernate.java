package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.data.PostDAO;
import com.revature.data.PostHibernate;
import com.revature.data.UserDAO;
import com.revature.data.UserHibernate;

@Service
public class HomeServiceHibernate implements HomeService {
	private UserDAO ud= new UserHibernate();
	private PostDAO pd= new PostHibernate();
	@Override
	public List<Post> getAllPosts() 
	{
		System.out.println("Got to HSH getAllPosts");
		return pd.getPosts();
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

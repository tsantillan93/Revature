package com.revature.services;

import java.util.List;

import com.revature.beans.Post;
import com.revature.beans.User;

public interface HomeService 
{
	public List<Post> getAllPosts();
	public void viewUserInfo(User u);
	public void updateUserInfo (User u);
}

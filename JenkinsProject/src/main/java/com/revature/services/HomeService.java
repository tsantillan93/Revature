package com.revature.services;

import java.util.Set;

import com.revature.beans.Post;
import com.revature.beans.User;

public interface HomeService 
{
	public Set<Post> getAllPosts();
	public void viewUserInfo(User u);
	public void updateUserInfo (User u);
}

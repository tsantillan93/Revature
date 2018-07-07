package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.data.PostDAO;
import com.revature.data.PostHibernate;

@Service
public class PostServiceHibernate implements PostService {
	private PostDAO pd= new PostHibernate();

	@Override
	public Post addPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePost(Post Post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Post> getMyPosts(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

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
	public  Post addPost(Post post) {
		//log.trace("Adding book to db");
		return pd.addPost(post);
	}

	@Override
	public Post getPost(int id) {
		Post post = pd.getPost(id);
		return post;
	}

	@Override
	public Post getPost(Post post) {
		Post functionPost = pd.getPost(post);
		return functionPost;
	}

	@Override
	public Post updatePost(Post post) {
		return pd.updatePost(post);
		
	}

	@Override
	public Set<Post> getPosts() {
		return pd.getPosts();
	}

	@Override
	public Set<Post> getMyPosts(User user) {
		return pd.getMyPosts(user);
	}

}

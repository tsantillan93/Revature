package com.revature.services;

import java.util.Set;

import com.revature.beans.Post;
import com.revature.beans.User;

public interface PostService {
	Post addPost(Post post);
	Post getPost(int id);
	Post getPost(Post post);
	Post updatePost(Post post);
	Set<Post> getPosts();
	Set<Post> getMyPosts(User user);


}

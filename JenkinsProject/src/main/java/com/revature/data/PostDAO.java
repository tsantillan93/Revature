package com.revature.data;

import java.util.Set;

import com.revature.beans.Post;
import com.revature.beans.User;

public interface PostDAO {
	Post addPost(Post post);
	Post getPost(int id);
	Post getPost(Post post);
	void updatePost(Post post);
	Set<Post> getPosts();
	Set<Post> getMyPosts(User user);

}

package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.data.UserDAO;
import com.revature.data.UserHibernate;
import com.revature.services.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	@Autowired
	private PostService postService;

	private UserDAO ud = new UserHibernate();;
    @RequestMapping(value = "/post", method = RequestMethod.POST) //maps POST requests to this function
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Post getPost(@PathVariable int id) {

    		Post p = postService.getPost(id);
		return p;
	}
	
    @RequestMapping(value = "/getPosts", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Post> getPosts() {
		Set<Post> posts = postService.getPosts();
		System.out.println("getPosts() in the PostController and here are the posts: " + posts);
		if(posts == null) 
		{
			return null;
		}
		return posts;
	}
	
    @RequestMapping(value = "/getMyPosts/{userId}", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Post>getMyPosts(@PathVariable("userId") int userId) {
    	System.out.println(userId);
    	User user = ud.getUserById(userId);
		Set<Post> myPosts = postService.getMyPosts(user);
		if(myPosts == null) 
		{
			return null;
		}
		System.out.println(myPosts);
		return myPosts;
	}
	
    @RequestMapping(value = "/post", method = RequestMethod.PUT) //maps PUT requests to this function
    @ResponseBody
	public void updatePost(@RequestBody Post p) {//may need to use @PathVariable if we're gonna have the post id in the uri
    	postService.updatePost(p);
	}

}

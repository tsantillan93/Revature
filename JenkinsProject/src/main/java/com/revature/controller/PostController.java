package com.revature.controller;

import java.util.List;
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
import com.revature.services.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	@Autowired
	private PostService postService;
    @RequestMapping(value = "/post", method = RequestMethod.POST) //maps POST requests to this function
	public Post addPost(@RequestBody Post post) {
		return postService.addPost(post);
	}
	
    @RequestMapping(value="{postId}", method=RequestMethod.GET)
	public Post getBook(@PathVariable("postId") int id) {
    	Post p =  postService.getPost(id);
		System.out.println(p);
		return p;
	}
	
    @RequestMapping(value = "/getPosts", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public List<Post> getPosts() {
		List<Post> posts = postService.getPosts();
		System.out.println("getPosts() in the PostController and here are the posts: " + posts);
		if(posts == null) 
		{
			return null;
		}
		return posts;
	}
	
    @RequestMapping(value = "/getMyPost", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Post>getMyPosts() {
		return null;
	}
	
    @RequestMapping(value = "/post", method = RequestMethod.PUT) //maps PUT requests to this function
    @ResponseBody
	public void updatePost() {
		
	}

}

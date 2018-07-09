package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
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
	
    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Post getPost(@PathVariable int id) {

    		Post p = postService.getPost(id);
		return p;
	}
	
    @RequestMapping(value = "/getPost", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Post> getPosts() {
		return null;
	}
	
    @RequestMapping(value = "/getMyPost", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Post>getMyPosts() {
		return null;
	}
	
    @RequestMapping(value = "/post", method = RequestMethod.PUT) //maps GET requests to this function
    @ResponseBody
	public void updatePost() {
		
	}

}

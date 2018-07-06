package com.revature.controller;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.services.HomeService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class HomeController
{
        @Autowired
        private HomeService homeService;

        @RequestMapping(value = "/home", method = RequestMethod.GET)
        public String getHome(HttpSession session)
        {
            if (session.getAttribute("user") == null) //the user is not logged in
            {
                    return "redirect:login";
            }

            //the user is logged in, therefore, can access the homepage
            return "static/home.html";
        }

        @RequestMapping(value = "/getPosts", method = RequestMethod.GET)
        public void getAllPosts()
        {
        	Set <Post> posts = homeService.getAllPosts();
        }
        
        @RequestMapping(value = "/viewUserInfo", method = RequestMethod.GET)
        public void viewUserInfo(HttpSession session) 
        {
        	User u = (User) session.getAttribute("user");
        	homeService.viewUserInfo(u);
        }
        
        @RequestMapping(value = "/updateUserInfo", method = RequestMethod.PUT)
        public void updateUserInfo(User u) 
        {
        	homeService.updateUserInfo(u);
        }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public String logout(HttpSession session)
        {
            //close the session
            session.invalidate();
            //redirect to the login page
            return "redirect:login";
        }
}


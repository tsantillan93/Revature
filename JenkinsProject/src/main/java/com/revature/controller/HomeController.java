package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.User;
import com.revature.services.HomeService;
import com.revature.services.PostService;

@RestController
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
        
        @RequestMapping(value = "/viewUserInfo", method = RequestMethod.GET)
        public void viewUserInfo(HttpSession session) 
        {
        	User u = (User) session.getAttribute("user");
        	homeService.viewUserInfo(u);
        }
        
        @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
        public User updateUserInfo(@RequestBody User u) 
        {
        	homeService.updateUserInfo(u);
        	return u;
        }

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
        public String logout(HttpSession session)
        {
            //close the session
            session.invalidate();
            //redirect to the login page
            return null;
        }
}


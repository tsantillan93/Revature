package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.beans.User;
import com.revature.services.LoginService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController
{
        @Autowired
        private LoginService loginService;

        @RequestMapping(value = "/login", method = RequestMethod.GET) //maps GET requests to this function
        @ResponseBody
        public User getLogin(HttpSession session)
        {
            if(session.getAttribute("user") == null)
            {
                //if the login was UNsuccessful, forward to the login page
                return null;
            }

            //if the login was successful, redirect to the home page/dashboard
            return (User) session.getAttribute("user");
        }
        
        @RequestMapping(value = "/register", method = RequestMethod.POST)
    	@ResponseBody
        public User register(@RequestBody User u) 
        {
        	System.out.println("Made it!");
        	System.out.println(u);
        	User user = loginService.register(u);
        	System.out.println(user);
        	if (user.getId() == 0) //if the registration was UNsuccessful, forward to the registration page
        	{
//        		return "redirect:registration";
        	}
        	
        	//if registration is successful, redirect to the login
        	return user;
        }
        
        //Tye added this to see of it fixed the method unsupported error but it didn't
        @RequestMapping(value = "/register", method = RequestMethod.GET)
        public String register() 
        {
        	return "redirect:login";
        }

        @RequestMapping(value = "/login", method = RequestMethod.POST) //maps POST requests to this function
        @ResponseBody
        public User login(String username, String password, HttpSession session) //making use of the LoginService method login()
        {            
        	System.out.println("Credentials Received-\n\tUsername: " + username + "\n\tPassword: " + password);

            User u = loginService.login(username, password);
            if (u == null) //the user has not registered
            {
                return null;
            }

            //the user's credentials are valid
            session.setAttribute("user", u);
            return u;
        }

        public void setLogin(LoginService login)
        {
            //instantiate the LoginService instance
            this.loginService = login;
        }
}

package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.services.LoginService;

@Controller
@RequestMapping(value = "/login") //maps the url
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController
{
        @Autowired
        private LoginService loginService;

        @RequestMapping(method = RequestMethod.GET) //maps GET requests to this function
        public String getLogin(HttpSession session)
        {
            if(session.getAttribute("user") == null)
            {
                //if the login was UNsuccessful, forward to the login page
                return "static/login.html";
            }

            //if the login was successful, redirect to the home page/dashboard
            return "redirect:home";
        }
        
        @RequestMapping(value = "/register", method = RequestMethod.POST)
        public String register(User u) 
        {
        	int userId = loginService.register(u);
        	if (userId == 0) //if the registration was UNsuccessful, forward to the registration page
        	{
        		return "static/registration.html";
        	}
        	
        	//if registration is successful, redirect to the login
        	return "redirect:login";
        }

        @RequestMapping(method = RequestMethod.POST) //maps POST requests to this function
        public String login(String username, String password, HttpSession session) //making use of the LoginService method login()
        {
            User u = loginService.login(username, password);
            System.out.println("Credentials Received-\n\tUsername: " + username + "\n\tPassword: " + password);
            if (u == null) //the user has not registered
            {
                return "redirect:login";
            }

            //the user's credentials are valid
            session.setAttribute("user", u);
            return "redirect:home";
        }

        public void setLogin(LoginService login)
        {
            //instantiate the LoginService instance
            this.loginService = login;
        }
}

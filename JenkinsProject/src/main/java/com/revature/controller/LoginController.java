package com.revature.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.beans.User;
import com.revature.services.LoginService;

@Controller
@RequestMapping(value = "/login") //maps the url
public class LoginController
{
        @Autowired
        private LoginService loginService;

        @RequestMapping(method = RequestMethod.GET) //maps GET requests to this function
        public String getLogin(HttpSession session)
        {
            if(session.getAttribute("user") == null)
            {
                //if the login was successful, forward to the login page
                return "static/login.html";
            }

            //if the login was UNsuccessful, redirect to the home page/dashboard
            return "redirect:home";
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

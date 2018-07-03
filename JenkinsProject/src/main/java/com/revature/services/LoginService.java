package com.revature.services;

import com.revature.beans.User;

public interface LoginService
{
        //Method signature to check a User's credentials
        public User login(String username, String password);

}


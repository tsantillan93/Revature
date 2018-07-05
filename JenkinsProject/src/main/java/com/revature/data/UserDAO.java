package com.revature.data;

import com.revature.beans.User;

public interface UserDAO {
	User getUser(String username, String Password);

	//Create
	int addUser(User u);

	User getUser(User u);

	void updateUser(User u);
}

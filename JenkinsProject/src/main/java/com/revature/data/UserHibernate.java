package com.revature.data;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.revature.beans.User;

public class UserHibernate implements UserDAO, HibernateSession {
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session  = session;
		
	}

	@Override
	public User getUser(String username, String password) {
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = session.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = q.getSingleResult();
		return u;
	}

}

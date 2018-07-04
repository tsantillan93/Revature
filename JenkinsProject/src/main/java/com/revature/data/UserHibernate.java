package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;


public class UserHibernate implements UserDAO, HibernateSession {
	private HibernateUtil hu = new HibernateUtil();
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session  = session;
		
	}

	@Override
	public User getUser(String username, String password) {
		session = hu.getSession();
		String query = "from User u where u.username=:username and u.password=:password";
		Query<User> q = session.createQuery(query, User.class);
		q.setParameter("username", username);
		q.setParameter("password", password);
		User u = q.getSingleResult();
		session.close();
		return u;
	}

	@Override
	public User addUser(User u) {
		Session session = hu.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.persist(u);
			t.commit();
			return u;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}

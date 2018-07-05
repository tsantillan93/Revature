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
	public int addUser(User u) {
		Session session = hu.getSession();
		Transaction t = null;
		try {
			t = session.beginTransaction();
			session.persist(u);
			t.commit();
			return 1;
		} catch(Exception e) {
			t.rollback();
			e.printStackTrace();
			return 0;
		} finally {
			session.close();
		}
	}

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User u) {
		Session s = hu.getSession();
		Transaction t = s.beginTransaction();
		s.update(u);
		t.commit();
		s.close();
		
	}

}

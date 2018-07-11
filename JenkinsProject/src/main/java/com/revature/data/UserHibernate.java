package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

@Component
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
	public User addUser(User u) 
	{
		session = hu.getSession();
		Transaction t = session.beginTransaction();
		try 
		{
			session.save(u);
			t.commit();
		} 
		
		catch(HibernateException e) 
		{
			t.rollback();
		} 
		
		finally 
		{
			session.close();
		}
		
		return u;
	}

	@Override
	public User getUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User u) {
		session = hu.getSession();
		Transaction t = session.beginTransaction();
		System.out.println(u);
		session.update(u);
		t.commit();
		session.close();
		
	}

	
	public User getUserById(int id) {
		session = hu.getSession();
		String query = "from User u where u.id=:id";
		Query<User> q = session.createQuery(query, User.class);
		q.setParameter("id", id);
		User u = q.getSingleResult();
		session.close();
		return u;
	}
}

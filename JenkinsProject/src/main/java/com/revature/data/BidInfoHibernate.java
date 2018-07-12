package com.revature.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.BidInfo;
import com.revature.utils.HibernateUtil;

public class BidInfoHibernate implements BidInfoDAO, HibernateSession{
	private HibernateUtil hu = new HibernateUtil();
	private Session session;
	
	@Override
	public void setSession(Session session) {
		this.session  = session;	
	}
	
	@Override
	public BidInfo addBidInfo(BidInfo info) {
		session = hu.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(info);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return info;
	}

	@Override
	public BidInfo getBidInfo(int postId) {
		// get a session
		Session s = hu.getSession();
		// get a post from the session
		BidInfo bi = s.get(BidInfo.class, postId);
		// close the resource
		s.close();
		// return the post
		return bi;
	}

	@Override
	public BidInfo updateBidInfo(BidInfo info) {
		Session session = hu.getSession();
		Transaction t = session.beginTransaction();
		session.update(info);
		t.commit();
		session.close();
		return info;
	}



}

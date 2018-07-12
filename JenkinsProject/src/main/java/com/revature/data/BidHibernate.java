package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.revature.beans.Bid;
import com.revature.beans.Post;
import com.revature.utils.HibernateUtil;

public class BidHibernate implements BidDAO, HibernateSession{
	private HibernateUtil hu = new HibernateUtil();
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session  = session;
		
	}

	@Override
	public Bid addBid(Bid bid) {
		session = hu.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(bid);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return bid;
	}

	@Override
	public Bid getBid(int id) {
		// get a session
		Session s = hu.getSession();
		// get a post from the session
		Bid bid = s.get(Bid.class, id);
		// close the resource
		s.close();
		// return the post
		return bid;
	}

	@Override
	public Bid updateBid(Bid bid) {
		Session session = hu.getSession();
		Transaction t = session.beginTransaction();
		session.update(bid);
		t.commit();
		session.close();
		
		return bid;
	}

	@Override
	public Set<Bid> getBids(int postId) {
		Session session = hu.getSession();
		String query = "from bid where post_id=:postId";
		Query<Bid> q = session.createQuery(query, Bid.class);
		q.setParameter("postId", postId);
		List<Bid> bidList = q.getResultList();
		Set<Bid> bidSet = new HashSet<Bid>();
		bidSet.addAll(bidList);
		session.close();
		
		return bidSet;
	}

}

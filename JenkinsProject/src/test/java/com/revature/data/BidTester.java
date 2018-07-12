package com.revature.data;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Bid;
import com.revature.utils.HibernateUtil;

public class BidTester {
	protected HibernateUtil hu;
	protected Session session;
	protected Transaction tx;
	protected HibernateSession o;
	
	@Before
	public void setup() {
		hu = new HibernateUtil();
		session = hu.getSession();
		tx = session.beginTransaction();
		o.setSession(session);

	}

	{ o = new BidHibernate(); }
	
	@Test
	public void testincorrectInformation() {
		BidHibernate o=(BidHibernate) this.o;
		Bid bo=o.getBid(4);
		assertThat(0,not(o.getBid(1).getAmount()));
	}
	@Test
	public void getbidinformation() {
		BidHibernate o=(BidHibernate) this.o;
		assertEquals("Testing ",o.getBid(2).getUser().getFirstName());
	}
	
	@After
	public void tearDown() {
		tx.rollback();
		session.close();		
		hu = null;
		session = null;
		tx = null;
		o = null;
	}
}

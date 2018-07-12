package com.revature.data;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	@Test
	public void addbidtest() {
		
	}
	@Test
	public void updatetest() {
		
	}
	@Test
	public void testincorrectInformation() {
		
	}
	@Test
	public void getbidinformation() {
		
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

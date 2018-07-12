package com.revature.data;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class PostTester  {
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

	{ o = new PostHibernate(); }
	User testuser = new User(1, "test", "test", "Testing", "Testing2", "test@email.com");
	Post postTesting = new Post(0, "JUnit", testuser, null, null, "Selling a JUnit Test", 0, 0, 24.99);

/*	@Test
	public void addposttest() {
		PostHibernate o = (PostHibernate) this.o;
		Post testpost=o.addPost(postTesting);
		assertEquals(postTesting.getTitle(),o.getPost(testpost.getId()).getTitle());
		tx.rollback();
		

	}
	@Test
	public void updatetest() {
		PostHibernate o = (PostHibernate) this.o;
		postTesting.setTitle("cool Junit");
		o.updatePost(postTesting);
		assertEquals("cool Junit",o.getPost(44).getTitle());
	}*/
	
	@Test
	public void testfailure() {
		PostHibernate o = (PostHibernate) this.o;
		Post gotpost = o.getPost(22);
		assertThat("RANDOM STUFF", not(gotpost.getTitle()));
	}
	@Test
	public void getaUser() {
		PostHibernate o = (PostHibernate) this.o;
		Post gotpost = o.getPost(41);
		assertEquals("anything", gotpost.getTitle());
		assertEquals(testuser.getId(),o.getPost(44).getOwner().getId());
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
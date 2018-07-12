package com.revature.data;

import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;

import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class UserTesterTest {
	User testuser = new User(0, "TestingJunit", "TestingJunit", "Test", "Junit", "junittesting@testing.junit");
	
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

	{ o = new UserHibernate(); }
	
	@Test
	public void addtest() {
	UserHibernate o = (UserHibernate) this.o;
		User testrsul=o.addUser(testuser);
		assertEquals(testrsul,o.getUserById(testrsul.getId()));// ensures a user was added to the database

	}
	@Test
	public void updatetest() {
	UserHibernate o = (UserHibernate) this.o;
		testuser.setId(82);
		testuser.setFirstName("Upgrad");
		testuser.setUsername("UpgradedLast");
		o.updateUser(testuser);
		assertEquals("Upgrad",o.getUserById(82).getFirstName());// ensures a user was added to the database

	}
	@Test
	public void testfailure() {
		UserHibernate o = (UserHibernate) this.o;
		User gotuser = o.getUserById(1);
		assertThat("yest", not(gotuser.getUsername()));
	}
	@Test
	public void getaUser() {
		UserHibernate o = (UserHibernate) this.o;
		User gotuser = o.getUserById(1);
		assertEquals("Test", gotuser.getUsername());
	}

}

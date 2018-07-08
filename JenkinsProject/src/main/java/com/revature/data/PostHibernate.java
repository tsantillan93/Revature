package com.revature.data;

import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import org.hibernate.query.Query;

import org.hibernate.Transaction;
import com.revature.beans.Post;
import com.revature.beans.User;
import com.revature.utils.HibernateUtil;

public class PostHibernate implements PostDAO, HibernateSession {
	private HibernateUtil hu = new HibernateUtil();
	private Session session;

	@Override
	public void setSession(Session session) {
		this.session  = session;
		
	}
	
	@Override
	public Post addPost(Post post) {
		session = hu.getSession();
		Transaction t = session.beginTransaction();
		try {
			session.save(post);
			t.commit();
		} catch(HibernateException e) {
			t.rollback();
		} finally {
			session.close();
		}
		return post;
	}

	@Override
	public Post getPost(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post getPost(Post post) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePost(Post Post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Post> getPosts() {
		System.out.println("In getPosts()");
		Session session = hu.getSession();
		System.out.println("Got the Session");
		String query = "from com.revature.beans.Post";
		Query<Post> actualQuery = session.createQuery(query, Post.class);
		System.out.println("Made the actual query I think");
		List<Post> postList = actualQuery.getResultList();
		System.out.println(postList);
		session.close();
		return postList;

	}

	@Override
	public Set<Post> getMyPosts(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

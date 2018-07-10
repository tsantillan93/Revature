package com.revature.data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

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
	public Post updatePost(Post post) {
		Session session = hu.getSession();
		Transaction t = session.beginTransaction();
		session.update(post);
		t.commit();
		session.close();
		
		return post;
	}

	@Override
	public Set<Post> getPosts() {
//		System.out.println("In getPosts()");
		Session session = hu.getSession();
//		System.out.println("Got the Session");
		String query = "from com.revature.beans.Post";
		Query<Post> actualQuery = session.createQuery(query, Post.class);
//		System.out.println("Made the actual query I think");
		List<Post> postList = actualQuery.getResultList();
		Set<Post> postSet = new HashSet<Post>();
		postSet.addAll(postList);
//		System.out.println(postList);
		session.close();
		return postSet;

	}

	@Override
	public Set<Post> getMyPosts(User user) {
		Session session = hu.getSession();
		String query = "from Post where user_id=:userId";
		Query<Post> q = session.createQuery(query, Post.class);
		q.setParameter("userId", user.getId());
		List<Post> postList = q.getResultList();
		Set<Post> postSet = new HashSet<Post>();
		postSet.addAll(postList);
		session.close();
		
		return postSet;
	}

}

package com.revature.data;

import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
		// get a session
		Session s = hu.getSession();
		// get a post from the session
		Post p = s.get(Post.class, id);
		// close the resource
		s.close();
		// return the post
		return p;
	}

	@Override
	public Post getPost(Post post) {
		// get a session
		Session s = hu.getSession();
		// get a post from the session
		Post p = s.get(Post.class, post.getId());
		// close the resource
		s.close();
		// return the post
		return p;
	}

	@Override
	public void updatePost(Post Post) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Set<Post> getPosts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Post> getMyPosts(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}

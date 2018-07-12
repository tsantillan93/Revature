package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BID")
public class Bid {
	@Id
	@Column(name="BID_ID")
	private int id;
	@Column(name="POST_ID")
	private int post;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private User user;
	private int ammount;
	
	public Bid() {
		super();
	}

	public Bid(int id, int post, User user, int ammount) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.ammount = ammount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPost() {
		return post;
	}

	public void setPost(int post) {
		this.post = post;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAmmount() {
		return ammount;
	}

	public void setAmmount(int ammount) {
		this.ammount = ammount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ammount;
		result = prime * result + id;
		result = prime * result + post;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bid other = (Bid) obj;
		if (ammount != other.ammount)
			return false;
		if (id != other.id)
			return false;
		if (post != other.post)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bid [id=" + id + ", post=" + post + ", user=" + user + ", ammount=" + ammount + "]";
	}
	
	


}

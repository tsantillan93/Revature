package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="BID")
public class Bid {
	@Id
	@Column(name="BID_ID")
	@SequenceGenerator(name="BIDID_SEQ", sequenceName="BIDID_SEQ",allocationSize = 1)
	@GeneratedValue(generator="BIDID_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column(name="POST_ID")
	private int post;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="USER_ID")
	private User user;
	private int amount;
	
	public Bid() {
		super();
	}

	public Bid(int id, int post, User user, int amount) {
		super();
		this.id = id;
		this.post = post;
		this.user = user;
		this.amount = amount;
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

	public int getAmount() {
		return amount;
	}

	public void setAmmount(int amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + amount;
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
		if (amount != other.amount)
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
		return "Bid [id=" + id + ", post=" + post + ", user=" + user + ", amount=" + amount + "]";
	}
	
	


}

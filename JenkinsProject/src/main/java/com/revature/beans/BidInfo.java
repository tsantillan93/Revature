package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BID_INFO")
public class BidInfo {
	@Id
	@Column(name="POST_ID")
	private int id;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="MAX_BID")
	private Bid maxBid;
	@Column(name="MIN_AMOUNT")
    private double minAmount;
	
	public BidInfo() {
		super();
	}

	public BidInfo(int id, Bid maxBid, double minAmount) {
		super();
		this.id = id;
		this.maxBid = maxBid;
		this.minAmount = minAmount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bid getMaxBid() {
		return maxBid;
	}

	public void setMaxBid(Bid maxBid) {
		this.maxBid = maxBid;
	}

	public double getMinAmount() {
		return minAmount;
	}

	public void setMinAmount(double minAmount) {
		this.minAmount = minAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((maxBid == null) ? 0 : maxBid.hashCode());
		long temp;
		temp = Double.doubleToLongBits(minAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		BidInfo other = (BidInfo) obj;
		if (id != other.id)
			return false;
		if (maxBid == null) {
			if (other.maxBid != null)
				return false;
		} else if (!maxBid.equals(other.maxBid))
			return false;
		if (Double.doubleToLongBits(minAmount) != Double.doubleToLongBits(other.minAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BidInfo [id=" + id + ", maxBid=" + maxBid + ", minAmount=" + minAmount + "]";
	}

}

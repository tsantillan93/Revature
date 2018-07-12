package com.revature.services;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.revature.beans.Bid;
import com.revature.data.BidDAO;
import com.revature.data.BidHibernate;

@Service
public class BidServiceHibernate implements BidService{
	private BidDAO  bd= new BidHibernate();

	@Override
	public Bid addBid(Bid bid) {
		return bd.addBid(bid);
	}

	@Override
	public Bid getBid(int id) {
		return bd.getBid(id);
	}

	@Override
	public Bid updateBid(Bid bid) {
		return bd.updateBid(bid);
	}

	@Override
	public Set<Bid> getBids(int postId) {
		return bd.getBids(postId);
	}

}

package com.revature.services;

import java.util.Set;

import com.revature.beans.Bid;

public interface BidService {
	Bid addBid(Bid bid);
	Bid getBid(int id);
	Bid updateBid(Bid bid);
	Set<Bid> getBids(int postId);

}

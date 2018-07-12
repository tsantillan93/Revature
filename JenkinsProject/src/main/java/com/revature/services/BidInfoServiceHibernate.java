package com.revature.services;

import com.revature.beans.BidInfo;
import com.revature.data.BidInfoDAO;
import com.revature.data.BidInfoHibernate;

public class BidInfoServiceHibernate implements BidInfoService{
	private BidInfoDAO bid = new BidInfoHibernate();
	@Override
	public BidInfo addBidInfo(BidInfo info) {
		return bid.addBidInfo(info);
	}

	@Override
	public BidInfo getBidInfo(int postId) {
		return bid.getBidInfo(postId);
	}

	@Override
	public BidInfo updateBidInfo(BidInfo info) {
		return bid.updateBidInfo(info);
	}

}

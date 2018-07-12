package com.revature.services;

import com.revature.beans.BidInfo;

public interface BidInfoService {
	BidInfo addBidInfo(BidInfo info);
	BidInfo getBidInfo(int postId);
	BidInfo updateBidInfo(BidInfo info);
}

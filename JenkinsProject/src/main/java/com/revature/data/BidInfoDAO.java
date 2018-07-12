package com.revature.data;

import com.revature.beans.BidInfo;

public interface BidInfoDAO {
	BidInfo addBidInfo(BidInfo info);
	BidInfo getBidInfo(int postId);
	BidInfo updateBidInfo(BidInfo info);
	
}

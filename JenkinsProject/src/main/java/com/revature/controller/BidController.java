package com.revature.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.Bid;
import com.revature.services.BidService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BidController {
	@Autowired
	private BidService bidService;

	
	
    @RequestMapping(value = "/bid", method = RequestMethod.POST) //maps POST requests to this function
	public Bid addbid(@RequestBody Bid bid) {
		return bidService.addBid(bid);
	}
    
    @RequestMapping(value = "/bid/{id}", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Bid getbid(@PathVariable int id) {
		return bidService.getBid(id);
	}
    
    @RequestMapping(value = "/bids/{postId}", method = RequestMethod.GET) //maps GET requests to this function
    @ResponseBody
	public Set<Bid>getBids(@PathVariable("postId") int postId) {
    	System.out.println(postId);
		return bidService.getBids(postId);
	}

}

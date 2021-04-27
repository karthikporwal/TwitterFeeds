package org.kp.twitterfeeds.service;


import java.util.ArrayList;
import java.util.List;

import org.kp.twitterfeeds.config.TwitterInstanceFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.TwitterException;

@Service
public class TwitterFeedsService {
	
	@Autowired
	private TwitterInstanceFactory twFactory;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public List<String> checkFeed() throws TwitterException {
		Query query = new Query("COVID");
	    QueryResult result = twFactory.getInstance().search(query);
	    List<String> feedList = new ArrayList<>();
	   
	    
	    result.getTweets().stream().forEach(
	    		(item -> feedList.add(item.getText())
	      ));
	    logger.info("checkFeed: returning feed list of :{} items", feedList.size());
	    return feedList;
	}

}

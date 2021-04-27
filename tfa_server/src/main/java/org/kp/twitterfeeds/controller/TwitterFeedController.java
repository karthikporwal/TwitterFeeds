package org.kp.twitterfeeds.controller;

import java.util.List;

import org.kp.twitterfeeds.constants.Constants;
import org.kp.twitterfeeds.model.TweetQueryResult;
import org.kp.twitterfeeds.model.TweetSearchResponse;
import org.kp.twitterfeeds.service.TwitterFeedsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import twitter4j.TwitterException;

@RestController
@RequestMapping(value = Constants.URI_TWITTER_FEEDS)
public class TwitterFeedController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Environment env;
	
	@Autowired
	private TwitterFeedsService tfService;
	
	@GetMapping(value=Constants.URI_GET_TWEETS)
	public ResponseEntity<TweetSearchResponse> getTweets(@PathVariable("keyword") String searchKey){
		List<TweetQueryResult> results;
		try {
			results = tfService.checkFeed(searchKey);
			TweetSearchResponse response = new TweetSearchResponse(HttpStatus.OK.name(), results);
			return new ResponseEntity<TweetSearchResponse>(response, HttpStatus.OK);
		} catch (TwitterException e) {
			logger.error("Failed in check feed ", e);
			TweetSearchResponse response = new TweetSearchResponse(HttpStatus.INTERNAL_SERVER_ERROR.name(), e.getErrorMessage());
			return new ResponseEntity<TweetSearchResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} 
		
	}

}

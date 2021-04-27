package org.kp.twitterfeeds.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

@Configuration
public class TwitterInstanceFactory {
	@Value("${oauth.consumerKey}")
	private String consumerKey;
	@Value("${oauth.consumerSecret}")
	private String consumerSecret;
	@Value("${oauth.accessToken}")
	private String accessToken;
	@Value("${oauth.accessTokenSecret}")
	private String accessTokenSecret;

	private Twitter twitter;
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@PostConstruct
	public Twitter getInstance() {
		logger.info(
				"loading twitter account with props, consumerKey: {}, consumerSecret: {}, accessToken: {}, accessSecret: {}",
				consumerKey, consumerSecret, accessToken, accessTokenSecret);
		if (twitter == null) {
			ConfigurationBuilder cb = new ConfigurationBuilder();
			cb.setDebugEnabled(true).setOAuthConsumerKey(consumerKey).setOAuthConsumerSecret(consumerSecret)
					.setOAuthAccessToken(accessToken).setOAuthAccessTokenSecret(accessTokenSecret);
			TwitterFactory tf = new TwitterFactory(cb.build());
			this.twitter = tf.getInstance();
		}
		return twitter;
		
	}

}

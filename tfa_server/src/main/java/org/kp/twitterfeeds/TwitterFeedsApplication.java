package org.kp.twitterfeeds;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:twitter4j.properties")
public class TwitterFeedsApplication {
	public static void main(String[] args) {
		 SpringApplication.run(TwitterFeedsApplication.class, args);
	}

}

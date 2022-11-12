package com.passinfracom.sentimentAnalyzer.tweeter.core.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetSearch {
	
	@JsonProperty("id")
	private Long tweetId ;
	
	@JsonProperty("text")
	private String tweet ;
	
	public Long getTweetId() {
		return tweetId;
	}

	public void setTweetId(Long tweetId) {
		this.tweetId = tweetId;
	}

	public String getTweet() {
		return tweet;
	}

	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

	public Long getAuthor() {
		return author;
	}

	public void setAuthor(Long author) {
		this.author = author;
	}

	@JsonProperty("author_id")
	private Long author ;
	
	
	

}

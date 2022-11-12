package com.passinfracom.sentimentAnalyzer.tweeter.core.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetMetadata {
	
	@JsonProperty("users")
	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	

}

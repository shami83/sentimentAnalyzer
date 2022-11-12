package com.passinfracom.sentimentAnalyzer.tweeter.core.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	
	@JsonProperty("id")
	private Long user_Id;
	@JsonProperty("name")
	private String  userName;
	@JsonProperty("username")
	private String  tweetAcount;
	@JsonProperty("location")
	private String  location;
	
	public Long getUser_Id() {
		return user_Id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((user_Id == null) ? 0 : user_Id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_Id == null) {
			if (other.user_Id != null)
				return false;
		} else if (!user_Id.equals(other.user_Id))
			return false;
		return true;
	}
	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTweetAcount() {
		return tweetAcount;
	}
	public void setTweetAcount(String tweetAcount) {
		this.tweetAcount = tweetAcount;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
	

}

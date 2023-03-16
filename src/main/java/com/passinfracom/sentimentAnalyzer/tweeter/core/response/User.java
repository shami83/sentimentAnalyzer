package com.passinfracom.sentimentAnalyzer.tweeter.core.response;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class User {

	@JsonProperty("id")
	private Long user_Id;
	@JsonProperty("name")
	private String userName;
	@JsonProperty("username")
	private String tweetAcount;
	@JsonProperty("location")
	private String location;
	@JsonProperty("profile_image_url")
	private String profileImageUrl;
	@JsonProperty("description")
	private String description;
	@JsonProperty("verified")
	private boolean verified;
	@JsonProperty("created_at")
	private Date createdAt;

	public Long getUser_Id() {
		return user_Id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createdAt, description, location, profileImageUrl, tweetAcount, userName, user_Id,
				verified);
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

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
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
		return Objects.equals(createdAt, other.createdAt) && Objects.equals(description, other.description)
				&& Objects.equals(location, other.location) && Objects.equals(profileImageUrl, other.profileImageUrl)
				&& Objects.equals(tweetAcount, other.tweetAcount) && Objects.equals(userName, other.userName)
				&& Objects.equals(user_Id, other.user_Id) && verified == other.verified;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", userName=" + userName + ", tweetAcount=" + tweetAcount + ", location="
				+ location + ", profileImageUrl=" + profileImageUrl + ", description=" + description + ", verified="
				+ verified + ", createdAt=" + createdAt + "]";
	}

	
}

package com.passinfracom.sentimentAnalyzer.tweeter.core.response;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.passinfracom.sentimentAnalyzer.core.SentimentMgr;

public class SearchResponse {

	@JsonProperty("data")
	List<TweetSearch> data;

	public List<TweetSearch> getData() {
		return data;
	}

	public void setData(List<TweetSearch> data) {
		this.data = data;
	}

	public TweetMetadata getIncludes() {
		return includes;
	}

	public void setIncludes(TweetMetadata includes) {
		this.includes = includes;
	}

	@JsonProperty("includes")
	TweetMetadata includes;

	public Map<Long, Map<String, Object>> simplifiedResponse() {
		Map<Long, Map<String, Object>> responseMap = new HashMap<>();

		for (TweetSearch search : this.getData()) {
			User mappedUser = new User();
			mappedUser.setUser_Id(search.getAuthor());
			try {
				Stream<User> userStream = this.getIncludes().getUsers().stream()
						.filter(user -> user.getUser_Id().equals(mappedUser.getUser_Id()));
				User user = userStream.distinct().findFirst().get();
				String sentiment = SentimentMgr.getInstance().extractSentiment(search.getTweet());
				Map<String, Object> values = new HashMap<>();
				values.put("tweet", search);
				values.put("user", user);
				values.put("sentiment", sentiment);
				responseMap.put(search.getTweetId(), values);
			} catch (Exception e) {
				System.out.println("user details not found " + mappedUser);
			}

		}

		return responseMap;

	}

}

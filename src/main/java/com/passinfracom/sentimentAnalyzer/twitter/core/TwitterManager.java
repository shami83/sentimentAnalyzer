package com.passinfracom.sentimentAnalyzer.twitter.core;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import com.passinfracom.sentimentAnalyzer.http.RestClient;
import com.passinfracom.sentimentAnalyzer.tweeter.core.response.SearchResponse;

import lombok.extern.slf4j.Slf4j;
import twitter4j.Tweet;
import twitter4j.TweetsResponse;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.TwitterV2;
import twitter4j.TwitterV2ExKt;
import twitter4j.conf.ConfigurationBuilder;

@Slf4j
@Component
public class TwitterManager {

	@Autowired
	private RestClient restClient;

	public List<Tweet> getTweet(long[] id) throws TwitterException {
		log.info("id {}", id);
		TwitterV2 twitter = getTwitterinstance();
		TweetsResponse status = twitter.getTweets(id, null, null, null, null, null,
				"author_id,referenced_tweets.id,geo.place_id");
		return status.getTweets();
	}

	public String getUserDetails(String username) {

		String url = "https://api.twitter.com/2/users/by/username/{username}";
		Map<String, String> params = new HashMap<String, String>();
		params.put("username", username);

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				// Add query parameter
				.queryParam("user.fields", "public_metrics");

		log.info("Calling :: {}", builder.build().toUriString());

		ResponseEntity<String> response = restClient.restExchangeBearer(builder.buildAndExpand(params).toUriString(),
				HttpMethod.GET, String.class, params);
		return response.getBody();

	}

	public Map<Long, Map<String, Object>> recentSearch(String hashTag) {

		String url = "https://api.twitter.com/2/tweets/search/recent";

		Map<String, String> params = new HashMap<String, String>();
		params.put("query", hashTag);
		params.put("expansions", "author_id,geo.place_id");

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
				// Add query parameter
				.queryParam("query", hashTag).queryParam("expansions", "author_id,geo.place_id")
				.queryParam("user.fields", "username,location");

		log.info("Calling :: {}" , builder.build().toUriString());

		ResponseEntity<SearchResponse> response = restClient.restExchangeBearer(builder.build().toUriString(),
				HttpMethod.GET, SearchResponse.class, params);
		SearchResponse entity = response.getBody();
		return entity.simplifiedResponse();

	}

	/*
	 * public Map<String,String> searchbyHashTag(String hashtag) throws
	 * TwitterException{ TwitterV2 twitter = getTwitterinstance();
	 * Map<String,String> hasTagResult = new HashMap<String,String>(); Query query =
	 * new Query(hashtag); TweetsResponse result = twitter.searchRecent(hashtag,
	 * null, hashtag, null, hashtag, hashtag, hashtag, hashtag, null, null, hashtag,
	 * null, hashtag) for (Status status : result.getTweets()) {
	 * hasTagResult.put(status.getUser().getScreenName(), status.getText());
	 * hasTagResult.put(status.getUser().getScreenName(),
	 * status.getGeoLocation().toString());
	 * hasTagResult.put(status.getUser().getScreenName(),
	 * Integer.valueOf(status.getFavoriteCount()).toString());
	 * 
	 * 
	 * 
	 * System.out.println("@" + status.getUser().getScreenName() + " : " +
	 * status.getText() + " : " + status.getGeoLocation()); }
	 * 
	 * 
	 * return hasTagResult;
	 * 
	 * }
	 */

	private TwitterV2 getTwitterinstance() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey("AoTCk72gD5lXamDygUYx7lgvg")
				.setOAuthConsumerSecret("avDusRFg285zcRoT5oZP2mvtxmhIGnTXZHZixiGKoATVWPV2Na")
				.setOAuthAccessToken("120486568-o5MCGsDaoPitMhq4uKJu9wJTHm3m52V0F6VrAdLu")
				.setOAuthAccessTokenSecret("PXIIzLeWdrwVAq7V4tMZJybOv0Vg08tEgiW6yUIwjmJaX");
		TwitterFactory tf = new TwitterFactory(cb.build());
		Twitter twitter = tf.getInstance();

		final TwitterV2 twitterV2 = TwitterV2ExKt.getV2(twitter);
		return twitterV2;

	}

}

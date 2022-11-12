package com.passinfracom.sentimentAnalyzer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passinfracom.sentimentAnalyzer.core.SentimantAnalyzerFactory;
import com.passinfracom.sentimentAnalyzer.core.SentimentAnalyzer;
import com.passinfracom.sentimentAnalyzer.core.command.ICommand;
import com.passinfracom.sentimentAnalyzer.core.command.TwitterCommand;
import com.passinfracom.sentimentAnalyzer.tweeter.core.TweeterManager;
import com.passinfracom.sentimentAnalyzer.tweeter.core.response.SearchResponse;

import twitter4j.Tweet;
import twitter4j.TwitterException;

@RestController
@RequestMapping("/tweeterhandle")
public class TweeterController {
	
	@Autowired
	TweeterManager mgr;
	@GetMapping("/tweet")
	Map<String,String> getTweet() {
		
		SentimantAnalyzerFactory factory = SentimantAnalyzerFactory.getInstance();
		SentimentAnalyzer analyzer= factory.findSentimentAnalyzer("StandfordSentimentAnalyzer");
		ICommand cmd = new TwitterCommand();
		Map map= new HashMap<String,String>();
		Map responseMap= new HashMap<String,String>();
		map.put("Tweet", "This is happy morning");
		cmd.buildCommand(map);
		responseMap= analyzer.anlyzeSentiment(cmd);			
		return responseMap;
	}
	
	@GetMapping("/search")
	List<Tweet> postTweet() throws TwitterException {
		TweeterManager mgr = new TweeterManager();
		long[] arr = {1428219971931238400L};
		return mgr.getTweet(arr);
		//return mgr.searchbyHashTag("Kohli");
	
		
	}
	
	@GetMapping("/recentSearch/{hashtag}")
	Map<Long, Map<String, Object>> recentSerach(@PathVariable String hashtag) throws TwitterException {
		return mgr.recentSearch(hashtag);
		
	}
	
	@GetMapping("/user/{name}")
	String fetchUserDetails(@PathVariable String name) throws TwitterException {
		return mgr.getUserDetails(name);
		
		
	}
	



}

package com.passinfracom.sentimentAnalyzer.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passinfracom.sentimentAnalyzer.core.SentimantAnalyzerFactory;
import com.passinfracom.sentimentAnalyzer.core.SentimentAnalyzer;
import com.passinfracom.sentimentAnalyzer.core.command.ICommand;
import com.passinfracom.sentimentAnalyzer.core.command.TwitterCommand;

@RestController
@RequestMapping("/tweeterhandle")
public class TweeterController {
	
	
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

}

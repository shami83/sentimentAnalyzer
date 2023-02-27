package com.passinfracom.sentimentAnalyzer.core;

import java.util.HashMap;
import java.util.Map;

import com.passinfracom.sentimentAnalyzer.core.command.ICommand;
import com.passinfracom.sentimentAnalyzer.core.command.TwitterCommand;

public class SentimentMgr {
	
	private static SentimentMgr instance = new SentimentMgr();
	
	private SentimentMgr() {
		
	}
	public static SentimentMgr getInstance() {
		return instance;
	}
	
	private SentimantAnalyzerFactory factory = SentimantAnalyzerFactory.getInstance();
	private SentimentAnalyzer analyzer= factory.findSentimentAnalyzer("StandfordSentimentAnalyzer");
	

		public String extractSentiment(String tweet) {			
			ICommand cmd = new TwitterCommand();
			Map<String,String> map= new HashMap<>();
			Map<String,String> responseMap= new HashMap<String,String>();
			map.put("Tweet", tweet);
			cmd.buildCommand(map);
			responseMap= analyzer.anlyzeSentiment(cmd);	
			return responseMap.get("SentimantType");
			
			
		}
}

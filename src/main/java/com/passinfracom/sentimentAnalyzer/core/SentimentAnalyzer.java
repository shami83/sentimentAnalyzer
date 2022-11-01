package com.passinfracom.sentimentAnalyzer.core;

import java.util.Map;

import com.passinfracom.sentimentAnalyzer.core.command.ICommand;

public interface SentimentAnalyzer {
	
	public void setup();
	public Map<String,String> anlyzeSentiment(ICommand command);
	

}

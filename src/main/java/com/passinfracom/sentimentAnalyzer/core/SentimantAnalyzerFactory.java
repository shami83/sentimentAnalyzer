package com.passinfracom.sentimentAnalyzer.core;

public class SentimantAnalyzerFactory {
	private static SentimantAnalyzerFactory instance = new SentimantAnalyzerFactory();

	public static SentimantAnalyzerFactory getInstance() {
		return instance;

	}

	private SentimantAnalyzerFactory() {

	}
	
	public SentimentAnalyzer findSentimentAnalyzer(String type) {
		
		if("StandfordSentimentAnalyzer".equalsIgnoreCase(type)) {
			StandfordSentimentAnalyzerImpl impl= new StandfordSentimentAnalyzerImpl();
			impl.setup();
			return impl;
		}
		return null;
		
	}

}

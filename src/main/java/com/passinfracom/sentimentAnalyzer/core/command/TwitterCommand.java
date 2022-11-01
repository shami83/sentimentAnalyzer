package com.passinfracom.sentimentAnalyzer.core.command;

import java.util.HashMap;
import java.util.Map;

public class TwitterCommand implements ICommand{
	
	Map twitterMap;

	@Override
	public void buildCommand(Map<String, String> map) {
		twitterMap = new HashMap<String, String>();
		map.forEach((k,v)->twitterMap.put(k,v));
		twitterMap.put("Source", "Twitter");
		
	}
	@Override
	public Map<String, String> getMap() {
		// TODO Auto-generated method stub
		return twitterMap;
	}

}

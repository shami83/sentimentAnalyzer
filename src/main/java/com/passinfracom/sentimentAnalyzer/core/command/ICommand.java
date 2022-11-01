package com.passinfracom.sentimentAnalyzer.core.command;

import java.util.Map;

public interface ICommand {
	
	public void buildCommand(Map<String,String> map);
	public Map<String,String>  getMap();

}

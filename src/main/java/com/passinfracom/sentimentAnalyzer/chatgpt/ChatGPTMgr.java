package com.passinfracom.sentimentAnalyzer.chatgpt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.passinfracom.sentimentAnalyzer.http.ChatGptRestClient;
import com.passinfracom.sentimentAnalyzer.http.RestClient;

import net.minidev.json.JSONObject;

@Component
public class ChatGPTMgr {
	
	@Autowired
	private ChatGptRestClient chatGptClient;
	
	private String CHATGPT_API = "https://api.openai.com/v1/completions";
	
	public String sendToChatGPT(String prompt) {
		JSONObject data = new JSONObject();
        data.put("model", "text-davinci-003");
        data.put("prompt", prompt);
        data.put("max_tokens", 4000);
        data.put("temperature", 1.0);
        
        ResponseEntity<String> response = chatGptClient.restExchangeBearer(CHATGPT_API, data.toJSONString(), HttpMethod.POST, String.class);
        return response.getBody();

	}


}

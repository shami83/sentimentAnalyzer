package com.passinfracom.sentimentAnalyzer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.passinfracom.sentimentAnalyzer.chatgpt.ChatGPTMgr;

@RestController
@RequestMapping("/ai")
public class ChatGptController {

	@Autowired
	ChatGPTMgr mgr;

	@GetMapping("/chatgpt/{prompt}")
	String recentSerach(@PathVariable String prompt) throws Exception {
		return mgr.sendToChatGPT(prompt);

	}

}



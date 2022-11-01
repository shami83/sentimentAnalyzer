package com.passinfracom.sentimentAnalyzer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweeterhandle")
public class TweeterController {
	
	
	@GetMapping("/tweet")
	String getTweet() {
		return "Tweet from Shamik Mitra";
	}

}

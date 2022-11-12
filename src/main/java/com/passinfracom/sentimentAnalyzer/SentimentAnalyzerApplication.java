package com.passinfracom.sentimentAnalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SentimentAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentimentAnalyzerApplication.class, args);
	}
	
	@Bean
	RestTemplate creteRestTemplet() {
		return new RestTemplate();
	}

}

package com.passinfracom.sentimentAnalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Sentiment Analysis API with chatGPT", version = "1.0", description = "Sentiment Analyzer"))
public class SentimentAnalyzerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentimentAnalyzerApplication.class, args);
	}

	@Bean
	RestTemplate creteRestTemplet() {
		return new RestTemplate();
	}

}

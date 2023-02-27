package com.passinfracom.sentimentAnalyzer.http;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ChatGptRestClient {

	@Autowired
	RestTemplate restTemplate;

	public HttpHeaders getRequestHeaderBearer() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer " + "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");

		return headers;

	}

	public HttpHeaders getRequestHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

	public <T> ResponseEntity<T> restExchangeBearer(String url, String body, HttpMethod httpMethod, Class<T> classObj) {

		return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, this.getRequestHeaderBearer()), classObj);

	}

	public <T> ResponseEntity<T> restExchange(String url, String body, HttpMethod httpMethod, Class<T> classObj,
			Map<String, String> params) {

		return restTemplate.exchange(url, httpMethod, new HttpEntity<>(body, this.getRequestHeader()), classObj,
				params);
	}
}

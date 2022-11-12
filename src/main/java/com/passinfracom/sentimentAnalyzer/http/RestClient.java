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
public class RestClient {

	@Autowired
	RestTemplate restTemplate;

	public HttpHeaders getRequestHeaderBearer() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization", "Bearer "
				+ "AAAAAAAAAAAAAAAAAAAAAGrQjAEAAAAAzGtIMTMlpLQFA2UYHEGlqB9r9KY%3DJmUMeRJf9YYfgbWwIaCbuqqEGI5APnToYtSUDaI98ruDxciDMJ");

		return headers;

	}

	public HttpHeaders getRequestHeader() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;

	}

	public <T> ResponseEntity<T> restExchangeBearer(String url, HttpMethod httpMethod, Class<T> classObj,Map<String,String> params) {

		return restTemplate.exchange(url, httpMethod, new HttpEntity<>("parameters", this.getRequestHeaderBearer()),
				classObj,params);

	}

	public <T> ResponseEntity<T> restExchange(String url, HttpMethod httpMethod, Class<T> classObj,Map<String,String> params) {

		return restTemplate.exchange(url, httpMethod, new HttpEntity<>("parameters", this.getRequestHeader()),
				classObj,params);
	}
}
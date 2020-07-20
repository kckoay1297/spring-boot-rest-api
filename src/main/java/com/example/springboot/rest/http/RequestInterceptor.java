package com.example.springboot.rest.http;

import org.springframework.http.client.ClientHttpRequest;

public interface RequestInterceptor {

	public void intercept(ClientHttpRequest request);
}

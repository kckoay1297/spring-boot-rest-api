package com.example.springboot.rest.http;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class BasicHttpInterceptFactory extends HttpComponentsClientHttpRequestFactory {

	private List<RequestInterceptor> interceptors;

	public BasicHttpInterceptFactory() {
	}

	public BasicHttpInterceptFactory(List<RequestInterceptor> interceptors) {
		this.interceptors = interceptors;
	}

	@Override
	public ClientHttpRequest createRequest(URI uri, HttpMethod httpMethod) throws IOException {
		ClientHttpRequest request = super.createRequest(uri, httpMethod);
		if(interceptors != null){
			for(RequestInterceptor interceptor: interceptors){
				interceptor.intercept(request);
			}
		}
		return request;
	}

}

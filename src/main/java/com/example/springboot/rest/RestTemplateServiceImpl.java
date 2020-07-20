package com.example.springboot.rest;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.context.ApplicationContext;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.springboot.rest.http.BasicHttpInterceptFactory;
import com.example.springboot.rest.http.RequestInterceptor;

@Service
public class RestTemplateServiceImpl implements RestTemplateService {
	
	@Inject
	private ApplicationContext applicationContext;

	@Override
	public RestTemplate getRestTemplate() {
		return new RestTemplate(getClientHttpRequestFactory());
	}
	
	private ClientHttpRequestFactory getClientHttpRequestFactory() {
		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = null;
		if (applicationContext.containsBean(("ipAuditInterceptor"))) {
			RequestInterceptor clientHttpRequestInterceptor = (RequestInterceptor) applicationContext
					.getBean(("ipAuditInterceptor"));
			List<RequestInterceptor> interceptors = new ArrayList<>();
			interceptors.add(clientHttpRequestInterceptor);
			clientHttpRequestFactory = new BasicHttpInterceptFactory(interceptors);
		}else{
			clientHttpRequestFactory = new BasicHttpInterceptFactory();
		}
		clientHttpRequestFactory.setConnectTimeout(20000);
		clientHttpRequestFactory.setConnectionRequestTimeout(5000);
		clientHttpRequestFactory.setReadTimeout(30000);
		clientHttpRequestFactory.setBufferRequestBody(false);
		return clientHttpRequestFactory;
	}
}

package com.example.springboot.rest;

import java.net.URI;

import javax.inject.Inject;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.springboot.rest.model.ResponseModel;

public abstract class RestBaseServiceImpl {

	protected abstract String getRestBasePath();

	@Inject
	private RestTemplateService restTemplateService;

	@SuppressWarnings("unchecked")
	protected <T> ResponseModel<T> get(String path, Object... params) {
		RestTemplate restTemplate = restTemplateService.getRestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl(getRestBasePath() + path).buildAndExpand(params).toUri();
		return restTemplate.getForObject(uri, (Class<ResponseModel<T>>) (Class<?>) ResponseModel.class);
	}

	protected <T, E> ResponseModel<T> getByEntityAndParams(String path,
			ParameterizedTypeReference<ResponseModel<T>> responseType, E ent, Object... params) {
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<E> requestEntity = new HttpEntity<E>(ent, requestHeaders);
		RestTemplate restTemplate = restTemplateService.getRestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl(getRestBasePath() + path).buildAndExpand(params).toUri();
		ResponseEntity<ResponseModel<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, requestEntity,
				responseType);
		return responseEntity.getBody();
	}

	protected <T, E> ResponseModel<T> postByEntity(String path,
			ParameterizedTypeReference<ResponseModel<T>> responseType, E ent) {
		HttpHeaders requestHeaders = new HttpHeaders();
		HttpEntity<E> requestEntity = new HttpEntity<E>(ent, requestHeaders);
		RestTemplate restTemplate = restTemplateService.getRestTemplate();
		URI uri = UriComponentsBuilder.fromHttpUrl(getRestBasePath() + path).build().toUri();
		ResponseEntity<ResponseModel<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, requestEntity,
				responseType);
		return responseEntity.getBody();
	}
	
}

package com.example.springboot.rest.http;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.client.ClientHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
public class IpAuditInterceptor implements RequestInterceptor {

	public void intercept(ClientHttpRequest request){
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest clientRequest = ((ServletRequestAttributes) requestAttributes).getRequest();

		String remoteAddr = clientRequest.getHeader("Proxy-Client-IP");
		if (remoteAddr == null || remoteAddr.isEmpty()) {
			
			remoteAddr = clientRequest.getHeader("X-Forwarded-For");
			
			if (remoteAddr == null || remoteAddr.isEmpty()) {
				remoteAddr = clientRequest.getRemoteAddr();
			}
		}
		request.getHeaders().add("sourceIP", remoteAddr);
		request.getHeaders().add("Application", "Demo");
	}

}

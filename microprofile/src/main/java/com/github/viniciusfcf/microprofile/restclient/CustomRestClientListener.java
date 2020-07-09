package com.github.viniciusfcf.microprofile.restclient;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.spi.RestClientListener;

public class CustomRestClientListener implements RestClientListener{

	@Override
	public void onNewClient(Class<?> serviceInterface, RestClientBuilder builder) {
		builder.register(CustomRequestFilter.class);
	}
    
}
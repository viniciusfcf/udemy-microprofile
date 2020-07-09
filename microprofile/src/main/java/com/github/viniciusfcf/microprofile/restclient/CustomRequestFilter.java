package com.github.viniciusfcf.microprofile.restclient;

import java.io.IOException;
import java.util.Collections;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

public class CustomRequestFilter implements ClientRequestFilter{

	@Override
	public void filter(ClientRequestContext requestContext) throws IOException {
		requestContext.getHeaders().put("HeaderFilter", Collections.singletonList("ABC"));
	}
    
}
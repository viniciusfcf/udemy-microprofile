package com.github.viniciusfcf.microprofile.config;

import java.util.Collections;
import java.util.Map;

import org.eclipse.microprofile.config.spi.ConfigSource;

public class NossoConfigSource implements ConfigSource {

	Map<String, String> propriedades = Collections.singletonMap("custom.config.source", "Udemy");

	@Override
	public Map<String, String> getProperties() {
		return propriedades;
	}

	@Override
	public String getValue(String propertyName) {
		// System.out.println("-----"+propertyName);
		return propriedades.get(propertyName);
	}

	@Override
	public String getName() {
		return "Meu ConfigSource";
	}
    
}
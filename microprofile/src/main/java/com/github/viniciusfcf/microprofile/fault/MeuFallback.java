package com.github.viniciusfcf.microprofile.fault;

import org.eclipse.microprofile.faulttolerance.ExecutionContext;
import org.eclipse.microprofile.faulttolerance.FallbackHandler;

public class MeuFallback implements FallbackHandler<String> {

	@Override
	public String handle(ExecutionContext context) {
		return "MInha classe de fallback";
	}

}

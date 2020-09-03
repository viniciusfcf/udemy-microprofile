package com.github.viniciusfcf.microprofile.health;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@Liveness
@ApplicationScoped
public class EstouVivoProbe implements HealthCheck {

	@Override
	public HealthCheckResponse call() {
        //faça sua verificacao
		return HealthCheckResponse.down("Banco de dados3");
	}
    
}
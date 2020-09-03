package com.github.viniciusfcf.microprofile.health;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.health.Readiness;

@ApplicationScoped
public class MeuMB {
    
    @Produces
    @Readiness
    public HealthCheck verificaBancoNovamente() {
        return () -> HealthCheckResponse.named("Novo banco READY").up().build();
    }

    @Produces
    @Liveness
    public HealthCheck verificaBancoNovamente2() {
        return () -> HealthCheckResponse.named("Novo banco LIVE").up().build();
    }

}
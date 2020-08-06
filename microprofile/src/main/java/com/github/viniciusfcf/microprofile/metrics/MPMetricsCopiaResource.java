package com.github.viniciusfcf.microprofile.metrics;


import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("/mp-metrics-copia")
@ApplicationScoped
public class MPMetricsCopiaResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    // @Counted(name = "meuContador", reusable = true, absolute = true)
    // @ConcurrentGauge
    // @Gauge(unit = "none")
    // @Metered
    // @Timed
    // @SimplyTimed
    public String methodname() throws InterruptedException {
        // Thread.sleep(5000);
        return "hello";
    }

    
}
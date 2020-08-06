package com.github.viniciusfcf.microprofile.metrics;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.annotation.Metric;
import org.eclipse.microprofile.metrics.annotation.RegistryType;

@Path("/mp-metrics")
@ApplicationScoped
public class MPMetricsResource {

    @Inject
    MPService service;

    // @Inject
    // ClasseCustomizada classeCustomizada;

    //METRIC
    @Inject
    @Metric(name = "counter")
    Counter counter;

    // @Inject
    // @Metric(name = "meter")
    // Meter meter;

    // @Inject
    // @Metric(name = "timer")
    // Timer timer;

    // @Inject
    // @Metric(name = "histogram")
    // Histogram histogram;

    // @Inject
    // @Metric(name = "simpleTimer")
    // SimpleTimer simpleTimer;

    // @Inject
    // @Metric(name = "concurrentGauge")
    // org.eclipse.microprofile.metrics.ConcurrentGauge concurrentGauge;

    @Inject
    MetricRegistry metricApplication;

    @Inject
    @RegistryType(type=MetricRegistry.Type.BASE)
    MetricRegistry baseApplication;

    @Inject
    @RegistryType(type=MetricRegistry.Type.VENDOR)
    MetricRegistry vendorApplication;


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
        service.metodo1();
        // counter.inc(2);
        // meter.mark(10);
        // timer.time();
        // histogram.update(333);
        // histogram.update(500);
        // simpleTimer.time();
        // concurrentGauge.inc();
        // hitPercentage.inc(1 );
        return "hello ";
    }

    @GET
    @Path("tambem")
    @Produces(MediaType.TEXT_PLAIN)
    // @Counted(name = "meuContador", reusable = true, absolute = true)
    // @ConcurrentGauge
    // @Gauge(unit = "none")
    // @Metered
    // @Timed
    // @SimplyTimed
    public String methodname2() throws InterruptedException {
        // Thread.sleep(5000);
        return "hello";
    }

    @GET
    @Path("criar-metricas")
    @Produces(MediaType.TEXT_PLAIN)
    public String criar() {
        Counter contador = metricApplication.counter("contador-2");
        contador.inc();
        // Metadata metadata = Metadata.builder()
        //     .withName("contador-2").withUnit("kg").build();
        // Counter contador2 = metricApplication.counter(metadata);
        // contador2.inc();
        return "OK "+contador.getCount();
    }

    @GET
    @Path("apagar-metricas")
    @Produces(MediaType.TEXT_PLAIN)
    public String apagar() {
        metricApplication.remove("contador-2");
        return "OK";
    }

    // @javax.enterprise.inject.Produces
    // @Metric(name="hitPercentage")
    // @ApplicationScoped
    // Counter hitPercentage = new Counter() {
    //     int c = 0;
	// 	@Override
	// 	public void inc() {
	// 		c++;
	// 	}

	// 	@Override
	// 	public void inc(long n) {
    //         c+=n;
	// 	}

	// 	@Override
	// 	public long getCount() {
	// 		return c;
	// 	}

    // };


    
}
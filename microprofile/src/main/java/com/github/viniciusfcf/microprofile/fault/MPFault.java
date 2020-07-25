package com.github.viniciusfcf.microprofile.fault;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("/mp-fault")
@RequestScoped
public class MPFault {

    AtomicInteger atomicInteger = new AtomicInteger();

    // @GET
    // @Path("timeout")
    // @Produces(MediaType.TEXT_PLAIN)
    // @Timeout(200)
    // public String timeout(@QueryParam("sleep") Integer sleep) throws InterruptedException {
    //     Thread.sleep(sleep);
    //     return "hello com timeout";
    // }

    // @GET
    // @Path("retry")
    // @Produces(MediaType.TEXT_PLAIN)
    // @Retry(maxRetries = 20, maxDuration = 1000)
    // public String timeout(@QueryParam("erros") Integer erros) throws Exception {

    //     if (atomicInteger.get() == 2) {
    //         Thread.sleep(1001);
    //     }

    //     if (atomicInteger.incrementAndGet() <= erros) {
    //         throw new Exception("Nosso erro: "+atomicInteger.get());
    //     }
    //     return "hello com retry";
    // }
    

    @GET
    @Path("fallback")
    @Produces(MediaType.TEXT_PLAIN)
    @Fallback(
        fallbackMethod = "meuFallback",
        // value = MeuFallback.class,
        skipOn = MyThrowable.class
        )
    public String fallback(@QueryParam("erro") Boolean erro) throws Throwable {

        if (erro) {
            throw new MyThrowable();
        }

        return "hello com fallback";
    }

    public String meuFallback(Boolean erro) {

        return "hello do metodo de Fallback!!!";
    }

    
}
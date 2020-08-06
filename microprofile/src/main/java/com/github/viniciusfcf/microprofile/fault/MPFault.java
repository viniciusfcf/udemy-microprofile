package com.github.viniciusfcf.microprofile.fault;

import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.viniciusfcf.microprofile.restclient.MunicipioDTO;
import com.github.viniciusfcf.microprofile.restclient.MunicipioService;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/mp-fault")
@RequestScoped
// @ApplicationScoped
public class MPFault {

    static AtomicInteger atomicInteger = new AtomicInteger();
    
    @Inject
    @RestClient
    MunicipioService service;

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
    

    // @GET
    // @Path("fallback")
    // @Produces(MediaType.TEXT_PLAIN)
    // @Fallback(
    //     fallbackMethod = "meuFallback"
    //     // value = MeuFallback.class,
    //     // skipOn = MyThrowable.class
    //     )
    // public String fallback(@QueryParam("erro") Boolean erro) throws Throwable {

    //     if (erro) {
    //         throw new NullPointerException();
    //     }

    //     return "hello com fallback";
    // }
    
    // public String meuFallback(Boolean erro) {
    //     return "hello do metodo de Fallback!!!";
    // }

    // @GET
    // @Path("circuit")
    // @Produces(MediaType.TEXT_PLAIN)
    // @CircuitBreaker(
    //     delay = 10000,
    //     successThreshold = 5,
    //     failureRatio = 0.25,
    //     requestVolumeThreshold = 4
    // )
    // public String circuit(@QueryParam("erro") Boolean erro) throws Throwable {

    //     if (erro) {
    //         throw new Exception("Erro programatico Nosso!!");
    //     }

    //     return "hello com circuit";
    // }

    // @GET
    // @Path("bulkhead")
    // @Produces(MediaType.TEXT_PLAIN)
    // @Bulkhead(value = 3)
    // public String bulkhead() throws Throwable {
    //     Thread.sleep(10000);
    //     return "hello com bulkhead";
    // }
    
    //Future ou CompletionStage. CompletableFuture
    // @GET
    // @Path("future")
    // @Produces(MediaType.APPLICATION_JSON)
    // @Asynchronous
    // @Bulkhead(value=3, waitingTaskQueue = 1)
    // public Future<String> future() throws Throwable {
    //     Thread.sleep(6000);
    //     CompletableFuture<String> f = new CompletableFuture<>();
    //     f.completeAsync(MPFault::sucesso);
    //     return f;
    // }

    // @GET
    // @Path("future")
    // @Produces(MediaType.APPLICATION_JSON)
    // @Asynchronous
    // @Retry(maxRetries = 3)
    // public Future<String> future() throws Throwable {
    //     atomicInteger.incrementAndGet();
    //     CompletableFuture<String> f = new CompletableFuture<>();
    //     f.completeAsync(MPFault::falha);
    //     return f;
    // }

    // @GET
    // @Path("stage")
    // @Produces(MediaType.APPLICATION_JSON)
    // @Asynchronous
    // @Retry(maxRetries = 3)
    // public CompletionStage<String> stage() throws Throwable {
    //     atomicInteger.incrementAndGet();
    //     CompletableFuture<String> f = new CompletableFuture<>();
    //     f.completeAsync(MPFault::falha);
    //     return f;
    // }

    // private static String sucesso() {
    //     return "SUCESSO!!";
    // }

    // private static String falha() {
    //     throw new NullPointerException("NULL: "+atomicInteger.get());
    // }

    
    @GET
    @Path("restclient")
    @Produces(MediaType.APPLICATION_JSON)
    public MunicipioDTO timeout() {
        return service.buscarMunicipio();
    }
    
}
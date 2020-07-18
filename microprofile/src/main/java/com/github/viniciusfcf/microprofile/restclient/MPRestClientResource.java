package com.github.viniciusfcf.microprofile.restclient;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CompletionStage;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.opentracing.Tracer;


@Path("mp-restclient")
@ApplicationScoped
public class MPRestClientResource {
    
    @Inject
    @RestClient
    MunicipioService service;

    @Inject
    Tracer tracer;

    @Inject
    ServicoIntermediario intermediario;

    @GET
    public String adicionarComGet(@QueryParam("idUF") Integer idUF) {
        tracer.activeSpan().log("Entrando no metodo GET");
        
        if(idUF == null) {
            idUF = 222;
        }
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        tracer.activeSpan().log("DTO Criado");
		return service.adicionar("Valor1", idUF, municipio).toString();
    }

    @GET
    @Path("com-service-intermediario")
    public String adicionaMunicipioIntermediario(@QueryParam("idUF") Integer idUF) {
        tracer.activeSpan().setBaggageItem("meuBI", "Valor do BI");

        String retornoAdicao = intermediario.adicionarMunicipio(idUF);
        System.out.println("BAGGAGE ITEMS Resource");
        tracer.activeSpan().context().baggageItems().forEach(System.out::println);
        return retornoAdicao;
    }

    @GET
    @Path("async")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<MunicipioDTO> adicionarComGetAsync() {
        Integer idUF  = 222;
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        return service.adicionarAsync(idUF, municipio);
        
    }


    @GET
    @Path("sem-cdi")
    public String adicionarComGet2() {
        Integer idUF  = 222;
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        MunicipioService serviceInterno = CDI.current()
            .select(MunicipioService.class, RestClient.LITERAL).get();
		return serviceInterno.adicionar("Valor2", idUF, municipio).toString();
    }

    @GET
    @Path("builder")
    public String adicionarComGet3() throws IllegalStateException, RestClientDefinitionException, URISyntaxException {
        Integer idUF  = 222;
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        MunicipioService serviceInterno = RestClientBuilder.newBuilder()
            .baseUri(new URI("http://localhost:8080")).build(MunicipioService.class);
		return serviceInterno.adicionar("Valor3", idUF, municipio).toString();
    }

}
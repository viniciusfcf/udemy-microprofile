package com.github.viniciusfcf.microprofile.restclient;

import java.net.URI;
import java.net.URISyntaxException;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("mp-restclient")
@ApplicationScoped
public class MPRestClientResource {
    
    @Inject
    @RestClient
    MunicipioService service;

    @GET
    public String adicionarComGet() {
        Integer idUF  = 222;
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
		return service.adicionar("Valor1", idUF, municipio).toString();
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
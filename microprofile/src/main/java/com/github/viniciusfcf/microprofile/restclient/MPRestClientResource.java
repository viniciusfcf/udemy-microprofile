package com.github.viniciusfcf.microprofile.restclient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
		return service.adicionar(idUF, municipio).toString();
    }

}
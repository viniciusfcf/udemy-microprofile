package com.github.viniciusfcf.microprofile.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("municipios")
@RegisterRestClient(configKey = "correios")
public interface MunicipioService {
    
    @POST
    @GET
    public MunicipioDTO adicionar(@QueryParam("idUF")Integer idUF, 
        MunicipioDTO municipio);

}
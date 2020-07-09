package com.github.viniciusfcf.microprofile.restclient;

import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

@Path("/municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class MunicipioResource {

    private AtomicInteger geradorID = new AtomicInteger();

    @POST
    public MunicipioDTO adicionar(@Context HttpHeaders headers, @QueryParam("idUF")Integer idUF, MunicipioDTO municipio) {
        System.out.println("----------------------------------------------");
        System.out.println("Adicionando Municipio");
        printHeaders(headers);

        municipio.setId(geradorID.incrementAndGet());
        return municipio;
    }

    private void printHeaders(HttpHeaders headers) {
        MultivaluedMap<String, String> requestHeaders = headers.getRequestHeaders();

        for (Entry<String, List<String>> entry : requestHeaders.entrySet()) {
            System.out.println("HEADER: "+entry.getKey());
            System.out.println("VALORES: "+entry.getValue());
        }
        System.out.println("----------------------------------------------");
    }
}
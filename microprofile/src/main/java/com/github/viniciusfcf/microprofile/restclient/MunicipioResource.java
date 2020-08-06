package com.github.viniciusfcf.microprofile.restclient;

import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;


import io.opentracing.Tracer;

@Path("/municipios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@ApplicationScoped
public class MunicipioResource {

    private AtomicInteger geradorID = new AtomicInteger();

    @Inject
    Tracer tracer;


    @POST
    public MunicipioDTO adicionar(@Context HttpHeaders headers, @QueryParam("idUF")Integer idUF, MunicipioDTO municipio) {
        tracer.activeSpan().log("POST chamado");
        tracer.activeSpan().setTag("MinhaTAG", "Valor");
        System.out.println("----------------------------------------------");
        System.out.println("Adicionando Municipio");
        System.out.println("BAGGAGE ITEMS -- MunicipioResource");
        
        tracer.activeSpan().context().baggageItems().forEach(System.out::println);
        


        printHeaders(headers);

        if(idUF.equals(0)) {
            throw new NotFoundException("UF não encontrada");
        }
        
        if(idUF.equals(1)) {
            throw new RuntimeException("Ocorreu um erro ao salvar municipio");
        }
        tracer.activeSpan().log("Validacoes Efetuadas");
        municipio.setId(geradorID.incrementAndGet());
        try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        tracer.activeSpan().log("Salvo no banco");
        return municipio;
    }

    @GET
    public List<MunicipioDTO> buscar(@Context HttpHeaders headers, @QueryParam("idUF")Integer idUF) {
        System.out.println("----------------------------------------------");
        System.out.println("BUSCANDO Municipio");
        printHeaders(headers);
        tracer.activeSpan().log("buscar no banco");
        if(idUF.equals(0)) {
            throw new NotFoundException("UF não encontrada");
        }
        
        if(idUF.equals(1)) {
            throw new RuntimeException("Ocorreu um erro ao buscar municipio");
        }

        return Collections.emptyList();
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
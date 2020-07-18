package com.github.viniciusfcf.microprofile.restclient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.opentracing.Traced;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.opentracing.Span;
import io.opentracing.Tracer;

@ApplicationScoped
@Traced
public class ServicoIntermediario {
    
    @Inject
    @RestClient
    MunicipioService service;

    @Inject
    Tracer tracer;
    
    public String adicionarMunicipio(Integer idUF) {
        System.out.println("BAGGAGE ITEMS ServiceIntermediario");
        tracer.activeSpan().context().baggageItems().forEach(System.out::println);
        tracer.activeSpan().setBaggageItem("MeuBIIntermediario", "Valor do BIIntermediario");

        if(idUF == null) {
            idUF = 222;
        }

        Span span = tracer.buildSpan("AdicionandoMunicipioREST").asChildOf(tracer.activeSpan())
            .withTag("tagCustomizada", "ValorDaTAG").start();
        
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        String retornoAdicionar = service.adicionar("Valor1", idUF, municipio).toString();

        span.finish();

        return retornoAdicionar;
    }

    public String adicionarMunicipioSemActive(Integer idUF) {
        System.out.println("BAGGAGE ITEMS ServiceIntermediario");

        if(idUF == null) {
            idUF = 222;
        }

        Span span = tracer.buildSpan("AdicionandoMunicipioREST").asChildOf(tracer.activeSpan())
            .withTag("tagCustomizada", "ValorDaTAG").start();
        
        MunicipioDTO municipio = new MunicipioDTO(null, "Maceio", 12000);
        String retornoAdicionar = service.adicionar("Valor1", idUF, municipio).toString();

        span.finish();

        return retornoAdicionar;
    }

}
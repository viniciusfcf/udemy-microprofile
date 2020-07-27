package com.github.viniciusfcf.microprofile.restclient;

import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.ext.DefaultClientHeadersFactoryImpl;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("municipios")
@RegisterRestClient(configKey = "correios")
@ClientHeaderParam(name = "UtilizandoClientHeaderParamInterface", value = "X1")
@RegisterClientHeaders(DefaultClientHeadersFactoryImpl.class)
//Funciona nos dois
// @RegisterProvider(CustomRequestFilter.class)
public interface MunicipioService {
    
    @POST
    @ClientHeaderParam(name = "UtilizandoClientHeaderParamMetodo", value = "X2")
    @ClientHeaderParam(name = "TokenGerado", value = "{gerarToken}")
    public MunicipioDTO adicionar(
        @HeaderParam("UtilizandoHeaderParam")
        String header,
        @QueryParam("idUF")Integer idUF, 
        MunicipioDTO municipio);

    @POST
    public CompletionStage<MunicipioDTO> adicionarAsync(
        @QueryParam("idUF")Integer idUF, 
        MunicipioDTO municipio);

    default String gerarToken(String header) {
        return header + "123";
    }


    class BeanParamExemplo {

        @HeaderParam("UtilizandoHeaderParam")
        String header;

        @QueryParam("idUF")Integer idUF;

        MunicipioDTO municipio;
    }

    //Exemplo utilizado de fault tolerance em um rest client
    @GET
    @Fallback(fallbackMethod = "criarMunicipioFixo")
    public MunicipioDTO buscarMunicipio();
    
    default MunicipioDTO criarMunicipioFixo() {
        return new MunicipioDTO(1, "Campina Grande", 20000);
    }
}
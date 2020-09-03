package com.github.viniciusfcf.microprofile.openapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/pessoas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "pessoa")
public class PessoaResource {

    @GET
    public String buscarPessoas() {
        return "hello";
    }

    @POST
    @Operation(deprecated = true,
        description = "Salva uma nova pessoa. É permitido apenas maiores de idade"
        ,operationId = "meuID"
        ,summary = "Salva uma nova pessoa"
    )
    public SalvarPessoaDTO salvarPessoa(@RequestBody(description = "Descricao Bonita") SalvarPessoaDTO dto) {
        return null;
    }

    @Path("{id}")
    @DELETE
    public String apagarPessoa(@PathParam("id") Integer id) {
        return "hello";
    }
    
    @Path("{id}/enderecos")
    @GET
    @Tag(name = "endereco")
    @Tag(name = "pessoa")
    public List<EnderecoDTO> buscarEnderecos(@PathParam("id") Integer id) {
        return null;
    }

}
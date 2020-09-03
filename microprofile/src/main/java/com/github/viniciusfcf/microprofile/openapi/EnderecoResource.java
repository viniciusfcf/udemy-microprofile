package com.github.viniciusfcf.microprofile.openapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;


@Path("/enderecos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "endereco")
public class EnderecoResource {

    @GET
    public List<EnderecoDTO> buscarEnderecos() {
        return null;
    }

    @GET
    @Path("{id}")
    @Operation(operationId = "buscando"
    )
    @APIResponse(responseCode = "200", content = @Content(
        mediaType = "application/json",
        schema = @Schema(implementation = EnderecoDTO.class)
    ))
    @APIResponse(responseCode = "404", description = "Caso Endereço não exista")
    public Response buscarEndereco(@PathParam("id") Integer id) {
        return null;
    }

}
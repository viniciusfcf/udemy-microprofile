package com.github.viniciusfcf.microprofile.jwt;


import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/mp-jwt")
public class MPJWT {

    @GET
    @Path("permit-all")
    @PermitAll
    @Produces(MediaType.TEXT_PLAIN)
    public String methodname() {
        return "permit-all";
    }

    @GET
    @Path("deny-all")
    @DenyAll
    @Produces(MediaType.TEXT_PLAIN)
    public String deny() {
        return "deny-all";
    }

    @Inject
    JsonWebToken token;

    @Inject
    @Claim(value = "abc", standard = Claims.preferred_username)
    String nome;

    @Inject
    @Claim(value = "abc", standard = Claims.preferred_username)
    Instance<String> nomeInst;

    // Nao funciona no quarkus
    // @Inject
    // @Claim(value = "upn")
    // Optional<String> nomeOp;

    @GET
    @Path("proprietario")
    @RolesAllowed("proprietario")
    @Produces(MediaType.TEXT_PLAIN)
    public String proprietario() {
        return "proprietario "+token.getName();
    }

    @GET
    @Path("ajudante")
    @RolesAllowed("ajudante")
    @Produces(MediaType.TEXT_PLAIN)
    public String ajudante() {
        return "ajudante";
    }
}
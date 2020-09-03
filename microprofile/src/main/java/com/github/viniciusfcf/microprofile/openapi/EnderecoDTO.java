package com.github.viniciusfcf.microprofile.openapi;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public class EnderecoDTO {

    @Schema(description  = "Nome completo da rua")
    public String rua;

    @NotNull
    public String cep;
    
    @Min(0)
    @Max(9999)
    public Integer numero;
}

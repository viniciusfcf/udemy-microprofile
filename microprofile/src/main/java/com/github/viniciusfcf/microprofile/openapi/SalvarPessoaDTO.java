package com.github.viniciusfcf.microprofile.openapi;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.media.Schema;


@Schema(name = "SalvarPessoa")
public class SalvarPessoaDTO {

    @Schema(description = "Nome completo da Pessoa", maxLength = 100)
    public String nome;

    @Schema(minimum = "18")
    public Integer idade;

    @Schema(maxItems = 2)
    public List<EnderecoDTO> enderecos;
}

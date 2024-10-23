package com.github.youssfbr.buscador.dtos;

public record EnderecoDTO(
        String cep ,
        String logradouro ,
        String complemento ,
        String unidade ,
        String bairro ,
        String localidade ,
        String uf ,
        String estado ,
        String regiao
) {
}

package com.github.youssfbr.buscador.aplicacao;

import com.github.youssfbr.buscador.dtos.EnderecoDTO;
import com.github.youssfbr.buscador.services.EnderecoService;
import com.github.youssfbr.buscador.utils.GeradorDeArquivo;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        EnderecoService enderecoService = new EnderecoService();

        Scanner sc = new Scanner(System.in);
        System.out.print("\nDigite um CEP para buscar: ");
        String busca = sc.nextLine();
        sc.close();

        try {
            final EnderecoDTO enderecoDTO = enderecoService.buscaEndereco(busca);
            System.out.println(enderecoDTO);
            final GeradorDeArquivo gerador = new GeradorDeArquivo();
            gerador.salvarJson(enderecoDTO);
        }
        catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }

    }
}

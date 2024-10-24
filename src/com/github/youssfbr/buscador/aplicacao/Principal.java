package com.github.youssfbr.buscador.aplicacao;

import com.github.youssfbr.buscador.dtos.EnderecoDTO;
import com.github.youssfbr.buscador.services.EnderecoService;

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
        }catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

    }
}

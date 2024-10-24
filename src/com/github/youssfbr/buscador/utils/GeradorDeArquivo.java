package com.github.youssfbr.buscador.utils;

import com.github.youssfbr.buscador.dtos.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorDeArquivo {

    public void salvarJson(EnderecoDTO endereco) throws IOException {

        final Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final FileWriter fileWriter = new FileWriter(endereco.cep() + ".json");
        fileWriter.write(gson.toJson(endereco));
        fileWriter.close();
    }
}

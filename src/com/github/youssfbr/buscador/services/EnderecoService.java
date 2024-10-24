package com.github.youssfbr.buscador.services;

import com.github.youssfbr.buscador.dtos.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class EnderecoService {
    private static final String HOST = "https://viacep.com.br/ws/";

    public EnderecoDTO buscaEndereco(String cep) throws RuntimeException {

       // final String url = HOST + cep + "/json/";
        final URI endereco = URI.create(HOST + cep + "/json/");

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
               // .uri(URI.create(url))
                .uri(endereco)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body() , EnderecoDTO.class);
        }
        catch (JsonSyntaxException | IllegalStateException | IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter o endereco apartir desse CEP");
        }
        finally {
            client.close();
        }
    }
}

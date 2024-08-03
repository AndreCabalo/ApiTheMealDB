package org.andrecabalo.Teste;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class TestandoApi {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome de uma receita: ");
        String nomeReceita = scanner.nextLine();

        System.out.println("Informações disponíveis para a receita " + nomeReceita + ":");

        String endereco = "https://www.themealdb.com/api/json/v1/1/search.php?s=";
        String enderecoCompleto = endereco + nomeReceita;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(enderecoCompleto))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}

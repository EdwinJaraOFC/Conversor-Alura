package com.alurachallenge.conversor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Conversor {
    private static final String API_KEY = "API_KEY"; // Crea tu API desde la página
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void realizarConversion(String monedaOrigen, String monedaDestino, double monto) {
        try {
            String url = BASE_URL + monedaOrigen;
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                ConversionResponse data = gson.fromJson(response.body(), ConversionResponse.class);

                if (data.conversion_rates().containsKey(monedaDestino)) {
                    double tasa = data.conversion_rates().get(monedaDestino);
                    double resultado = monto * tasa;

                    System.out.printf("Tasa actual: 1 %s = %.4f %s\n", monedaOrigen, tasa, monedaDestino);
                    System.out.printf("Resultado: %.2f %s = %.2f %s\n", monto, monedaOrigen, resultado, monedaDestino);
                } else {
                    System.out.println("No se encontró la moneda destino: " + monedaDestino);
                }

            } else {
                System.out.println("Error al obtener los datos. Código HTTP: " + response.statusCode());
            }

        } catch (JsonSyntaxException e) {
            System.out.println("Error al procesar la respuesta JSON: " + e.getMessage());
        } catch (IOException | InterruptedException e) {
            System.out.println("Error de conexión con la API: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }
}

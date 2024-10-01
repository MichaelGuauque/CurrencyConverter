package model;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConverterApi {

    public ChangeDTO changeCurrency(Change change){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/fb10acede45d2a99b87e8e08/pair/"
                +change.getMonedaBase() +"/"
                +change.getMonedaCambiar()+"/"
                +change.getMontoAConvertir());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return new Gson().fromJson(response.body(), ChangeDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Error: no se pudo hacer la conversion, verifique los datos suministrados");
        }
    }
}

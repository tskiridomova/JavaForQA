package lesson6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    private static final String apiUrl = "http://dataservice.accuweather.com";
    private static final String forecastPath5Day = "/forecasts/v1/daily/5day/";
    private static final String apiKey = "DkpkL8WfWdvUxGEP27MQ5Dv0WMG3xRGN";
    private static final String locationKey = "295212"; // Saint-Petersburg, Russia

    public static void main(String[] args) {
        // 
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(apiUrl);
        urlBuilder.append(forecastPath5Day);
        urlBuilder.append(locationKey);
        urlBuilder.append("?apikey=" + apiKey);
        urlBuilder.append("&metric=true");

        System.out.println("Lesson 6");
        System.out.println(urlBuilder.toString());

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlBuilder.toString())).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
                .join();
    }
}

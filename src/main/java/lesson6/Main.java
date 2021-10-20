package lesson6;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    private static final String API_URL = "http://dataservice.accuweather.com";
    private static final String FORECAST_PATH_5DAY = "/forecasts/v1/daily/5day/";
    private static final String API_KEY = "DkpkL8WfWdvUxGEP27MQ5Dv0WMG3xRGN";
    private static final String LOCATION_ID = "295212"; // Saint-Petersburg, Russia

    public static void main(String[] args) {
        // 
        StringBuilder urlBuilder = new StringBuilder();
        urlBuilder.append(API_URL);
        urlBuilder.append(FORECAST_PATH_5DAY);
        urlBuilder.append(LOCATION_ID);
        urlBuilder.append("?apikey=" + API_KEY);
        urlBuilder.append("&metric=true");

        System.out.println("Lesson 6");
        System.out.println(urlBuilder);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(urlBuilder.toString())).build();
        client.sendAsync(request, BodyHandlers.ofString()).thenApply(HttpResponse::body).thenAccept(System.out::println)
                .join();
    }
}

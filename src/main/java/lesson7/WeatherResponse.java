package lesson7;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1

import java.util.List;

public class WeatherResponse {
    public Weather weather;

    public WeatherResponse(String body) {
        parseBody(body);
    }

    private void parseBody(String body) {
        ObjectMapper om = new ObjectMapper();
        try {
            this.weather = om.readValue(body, Weather.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

    public void forecastReport() {
        for(DailyForecast forecast: this.weather.dailyForecasts) {
            System.out.printf("| В городе %s на дату %s ожидается %s, температура - %s |%n",
                    ApplicationGlobalState.getInstance().getSelectedCity(),
                    forecast.date,
                    forecast.day.iconPhrase,
                    forecast.temperature.minimum
                    );
        }
    }
}



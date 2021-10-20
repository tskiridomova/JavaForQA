package lesson8;

import lesson8.entity.WeatherData;
import lesson8.enums.Functionality;
import lesson8.enums.Periods;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {

    WeatherProvider weatherProvider = new AccuWeatherProvider();
    Map<Integer, Functionality> variantResult = new HashMap();

    public Controller() {
        variantResult.put(1, Functionality.GET_CURRENT_WEATHER);
        variantResult.put(2, Functionality.GET_WEATHER_IN_NEXT_5_DAYS);
        variantResult.put(3, Functionality.GET_WEATHER_FROM_DB);
    }

    public void onUserInput(String input) throws IOException, SQLException {
        int command = Integer.parseInt(input);
        if (!variantResult.containsKey(command)) {
            throw new IOException("There is no command for command-key " + command);
        }

        switch (variantResult.get(command)) {
            case GET_CURRENT_WEATHER:
                getCurrentWeather();
                break;
            case GET_WEATHER_IN_NEXT_5_DAYS:
                getWeatherIn5Days();
                break;
            case GET_WEATHER_FROM_DB:
                getWeatherFromDB();
                break;
        }
    }

    public void getCurrentWeather() throws IOException {
        System.out.println(weatherProvider.getWeather(Periods.NOW).toString());
    }

    public void getWeatherFromDB() throws IOException, SQLException {
        List<WeatherData> result = weatherProvider.getAllFromDb();
        for(WeatherData data: result) {
            System.out.println(data.toString());
        }
    }

    public void getWeatherIn5Days() {
        throw new RuntimeException("Implement in h/w");
    }
}

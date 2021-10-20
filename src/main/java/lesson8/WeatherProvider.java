package lesson8;

import lesson8.enums.Periods;
import lesson8.entity.WeatherData;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface WeatherProvider {

    WeatherData getWeather(Periods periods) throws IOException;

    List<WeatherData> getAllFromDb() throws IOException, SQLException;
}

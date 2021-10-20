package lesson8;

import lesson8.entity.WeatherData;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (\n" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "city TEXT NOT NULL,\n" +
            "date_time TEXT NOT NULL,\n" +
            "weather_text TEXT NOT NULL,\n" +
            "temperature REAL NOT NULL\n" +
            ")";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_text, temperature) VALUES (?,?,?,?)";
    String selectWeatherQuery = "SELECT * FROM weather where city = ?";

    public DatabaseRepositorySQLiteImpl() {
        this.filename = ApplicationGlobalState.getInstance().getDbFileName();
        this.createTableIfNotExists();
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + filename);
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(WeatherData weatherData) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
            saveWeather.setString(1, weatherData.getCity());
            saveWeather.setString(2, weatherData.getLocalDate());
            saveWeather.setString(3, weatherData.getText());
            saveWeather.setDouble(4, weatherData.getTemperature());
            return saveWeather.execute();
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }

        throw new SQLException("Failure on saving weather object");
    }

    @Override
    public List<WeatherData> getAllSavedData() throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(selectWeatherQuery)) {
            statement.setString(1, ApplicationGlobalState.getInstance().getSelectedCity());
            ResultSet rs = statement.executeQuery();
            List<WeatherData> weatherData = new ArrayList<>();
            while (rs.next()) {
                weatherData.add(new WeatherData(
                        rs.getString("city"),
                        rs.getString("date_time"),
                        rs.getString("weather_text"),
                        rs.getDouble("temperature")
                ));
            }
            connection.close();
            return weatherData;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        throw new SQLException("Failure on loading weather from db");
    }
}

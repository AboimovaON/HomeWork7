import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DbHandler { public final String PATH_TO_DB = "jdbc:sqlite:C:\\Users\\olgaa\\IdeaProjects\\Lesson_8\\src\\main\\resources\\University.db";

    public final Connection connection;

    public DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(PATH_TO_DB);
    }

    public void addWeather(Weather weather) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Accuweather ('city', 'localDate', 'weatherText', 'temperature') " +
                        "VALUES(?, ?, ?, ?) "
        )){

            statement.setObject(1, Weather.city);
            statement.setObject(2, Weather.localDate);
            statement.setObject(3, Weather.weatherText);
            statement.setObject(4, Weather.temperature);
            //statement.execute();
        }catch (SQLException exception){
            exception.printStackTrace();
        }
    }
    public void deleteWeather(String city)  {
        try (PreparedStatement statement = this.connection.prepareStatement(
                " DELETE FROM Weather where city = ? "
        )) {
            statement.setObject(1, city);
            statement.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
    }
    public List<Weather> getAllWeather() {
        List<Weather> weathers = new ArrayList<>();
        try (Statement statement = this.connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(
                    " SELECT city, localDate, weatherText, temperature FROM Weather ")) {
                while (resultSet.next()) {
                    return Weather.add(new Weather(
                            resultSet.getString("city"),
                            resultSet.getString("localDate"),
                            resultSet.getInt("weatherText"),
                            (double) resultSet.getInt("temperature")
                    ));

                }
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return weathers;
    }
    }

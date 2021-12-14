import java.util.List;
import java.util.Objects;

public class Weather {

    static public String city;
    static public String localDate;
    static public int weatherText;
    static public Double temperature;


    public Weather(String city, String localDate, int weatherText, Double temperature) {
        this.city = city;
        this.localDate = localDate;
        this.weatherText = weatherText;
        this.temperature = temperature;
    }

    public Weather(String city) {
    }



    @Override
    public String toString() {
        return new StringBuilder().append(city).append(" ").append(localDate).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weather weather = (Weather) o;
        return city == weather.city && Objects.equals(city, city);
    }
}
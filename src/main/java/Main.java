import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        String city = sc.nextLine();

        String cityCode = RequestHandler.detectWheather(city);

        System.out.println(RequestHandler.detectWheather(cityCode));

        System.out.println(RequestHandler.getAllWeather());
        System.out.println(RequestHandler.getAllWeather());

    }
}

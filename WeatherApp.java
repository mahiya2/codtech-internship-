import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONObject;

public class WeatherApp {

    public static void main(String[] args) {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=17.7&longitude=83.3&current_weather=true";

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 🔥 JSON Parsing starts here
            JSONObject json = new JSONObject(response.body());
            JSONObject weather = json.getJSONObject("current_weather");

            double temp = weather.getDouble("temperature");
            double wind = weather.getDouble("windspeed");
            int direction = weather.getInt("winddirection");
            String time = weather.getString("time");

            // ✅ Clean Output
            System.out.println("=== Weather Report ===");
            System.out.println("Time: " + time);
            System.out.println("Temperature: " + temp + " °C");
            System.out.println("Wind Speed: " + wind + " km/h");
            System.out.println("Wind Direction: " + direction + "°");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
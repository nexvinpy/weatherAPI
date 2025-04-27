import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;


public class weatherAPI {
    private String apiKey;
    private String location;

    private double temp;
    private double feelsLike;
    private int humidity;
    private String description;

    public weatherAPI(String apiKey, String location) {
        this.apiKey = apiKey;
        this.location = location;
    }

    void getWeather() {
        String urlString = "https://api.openweathermap.org/data/2.5/weather?q=" + location +
                "&appid=" + apiKey + "&units=metric&lang=de";

        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream())
            );
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            System.out.println("Antwort von OpenWeather:");
            JSONObject json = new JSONObject(response.toString());
            System.out.println(json.getString("name"));

            JSONObject main = json.getJSONObject("main");

            JSONArray weatherArray = json.getJSONArray("weather");
            String description = weatherArray.getJSONObject(0).getString("description");

            this.temp = main.getDouble("temp");
            this.feelsLike = main.getDouble("feels_like");
            this.humidity = main.getInt("humidity");
            this.description = weatherArray.getJSONObject(0).getString("description");

            /*
            System.out.println("Temperatur: " + temp + " °C");
            System.out.println("Gefühlt: " + feelsLike + " °C");
            System.out.println("Luftfeuchtigkeit: " + humidity + " %");
            System.out.println("Wetter: " + description);
            */

        } catch (Exception e) {
            System.out.println("Fehler: " + e.getMessage());
        }
    }

    public double getTemp() {
        return temp;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public int getHumidity() {
        return humidity;
    }

    public String getDescription() {
        return description;
    }
}


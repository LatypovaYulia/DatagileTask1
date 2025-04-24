package app;

import api.CurrentWeatherApi;
import io.restassured.response.ValidatableResponse;
import model.WeatherResponse;

public class CurrentWeatherMain {

    public static void main(String[] args) {
        String apiKey = "9f9ec8e84c15427fadb201700252204";
        String coordinates = "59.9310,30.3609";
        String lang = "ru";

        CurrentWeatherApi api = new CurrentWeatherApi();
        ValidatableResponse response = api.getCurrentWeather(apiKey, coordinates, lang);
        WeatherResponse weather = response
                .statusCode(200)
                .extract()
                .as(WeatherResponse.class);
        System.out.println(weather);
    }
}

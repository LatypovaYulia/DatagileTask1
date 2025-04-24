package api;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;

public class CurrentWeatherApi {
    static final String GET_CURRENT_WEATHER_URI = "/current.json";

    @Step("Get current weather")
    public ValidatableResponse getCurrentWeather(String apiKey, String coordinates, String lang) {
        return RestAssured
                .given()
                .spec(RestApi.requestSpecification())
                .queryParam("key", apiKey)
                .queryParam("q", coordinates)
                .queryParam("lang", lang)
                .when()
                .get(GET_CURRENT_WEATHER_URI)
                .then();
    }

    @Step("Get current weather without Api Key")
    public ValidatableResponse getCurrentWeatherWithoutApiKey(String coordinates, String lang) {
        return RestAssured
                .given()
                .spec(RestApi.requestSpecification())
                .queryParam("q", coordinates)
                .queryParam("lang", lang)
                .when()
                .get(GET_CURRENT_WEATHER_URI)
                .then();
    }
}
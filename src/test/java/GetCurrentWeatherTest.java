import api.CurrentWeatherApi;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;

public class GetCurrentWeatherTest {
    String apiKey = "9f9ec8e84c15427fadb201700252204";
    String coordinates = "59.9310,30.3609";
    String lang = "ru";

    @Test
    @DisplayName("Get current weather")
    @Description("Check that we get current weather with successful result")
    public void getCurrentWeatherSuccessfulResultTest() {
        CurrentWeatherApi api = new CurrentWeatherApi();
        ValidatableResponse response = api.getCurrentWeather(apiKey, coordinates, lang);
        response.assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("location.name", is("Санкт-Петербург"));
    }

    @Test
    @DisplayName("Get current weather without Api key")
    @Description("Check that we can't get current weather without Api key and return error")
    public void getCurrentWeatherWithoutApiKeyTest() {
        CurrentWeatherApi api = new CurrentWeatherApi();
        ValidatableResponse response = api.getCurrentWeatherWithoutApiKey(coordinates, lang);
        response.assertThat()
                .statusCode(HttpStatus.SC_UNAUTHORIZED)
                .body("error.message", is("API key is invalid or not provided."));
    }

    @Test
    @DisplayName("Get current weather with invalid coordinates")
    @Description("Check that we can't get current weather with invalid coordinates and return error")
    public void getCurrentWeatherWithInvalidCoordinatesTest() {
        CurrentWeatherApi api = new CurrentWeatherApi();
        ValidatableResponse response = api.getCurrentWeather(apiKey, "0", lang);
        response.assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST)
                .body("error.message", is("No matching location found."));
    }
}

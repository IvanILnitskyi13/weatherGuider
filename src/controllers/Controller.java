package controllers;

import com.squareup.okhttp.OkHttpClient;
import external.AccuWeatherApiClient;
import external.fiveDayForecast.DailyForecasts;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    private Button getData;

    @FXML
    void initialize() {
        getData.setOnAction(actionEvent -> {
            AccuWeatherApiClient apiClient = new AccuWeatherApiClient(new OkHttpClient());
           DailyForecasts df = apiClient.getFiveDayForecast("bydgoszcz");
            System.out.println(df);
        });

    }
}

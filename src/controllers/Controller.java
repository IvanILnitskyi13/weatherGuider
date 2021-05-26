package controllers;

import com.squareup.okhttp.OkHttpClient;
import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import external.AccuWeatherApiClient;
import external.forecasts.Icons;
import external.forecasts.fiveDayForecast.FiveDayForecast;
import external.forecasts.twelveHoursForecast.TwelveHoursForecast;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicInteger;

public class Controller {

    @FXML
    private TextField city;

    @FXML
    private WeatherIconView todayIcon;

    @FXML
    private Text mainMinTemp;

    @FXML
    private Text mainMaxTemp;

    @FXML
    private Text wind;

    @FXML
    private Text humidity;

    @FXML
    private Text temp;

    @FXML
    private Text todayDayOfWeek;

    @FXML
    private Text description;

    @FXML
    private Text twoDayAfterDayOfWeek;

    @FXML
    private WeatherIconView twoDayAfterIcon;

    @FXML
    private Text twoDayAfterMaxTemp;

    @FXML
    private Text twoDayAfterMinTemp;

    @FXML
    private Text threeDayAfterDayOfWeek;

    @FXML
    private Text threeDayAfterMaxTemp;

    @FXML
    private Text threeDayAfterMinTemp;

    @FXML
    private Text fourDayAfterDayOfWeek;

    @FXML
    private WeatherIconView threeDayAfterIcon;

    @FXML
    private WeatherIconView fourDayAfterIcon;

    @FXML
    private Text fourDayAfterMaxTemp;

    @FXML
    private Text fourDayAfterMinTemp;

    @FXML
    private Button getData;

    @FXML
    private Text oneDayAfterDayOfWeek;

    @FXML
    private WeatherIconView oneDayAfterIcon;

    @FXML
    private Text oneDayAfterMaxTemp;

    @FXML
    private Text oneDayAfterMinTemp;

    @FXML
    private Button buttonNext;

    @FXML
    private Button buttonBack;

    @FXML
    private WeatherIconView timeOneIcon;

    @FXML
    private WeatherIconView timeTwoIcon;

    @FXML
    private WeatherIconView timeThreeIcon;

    @FXML
    private WeatherIconView timeFourIcon;

    @FXML
    private Text timeOneTemp;

    @FXML
    private Text timeTwoTemp;

    @FXML
    private Text timeThreeTemp;

    @FXML
    private Text timeFourTemp;

    @FXML
    private Text timeOne;

    @FXML
    private Text timeTwo;

    @FXML
    private Text timeThree;

    @FXML
    private Text timeFour;

    @FXML
    private Text sunRise;

    @FXML
    private Text moonRise;

    @FXML
    private Text timeNow;

    @FXML
    void initialize() {

        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            timeNow.setText(LocalTime.now().truncatedTo(ChronoUnit.SECONDS).toString());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();

        getData.setOnAction(actionEvent -> {
            AccuWeatherApiClient accuWeatherApiClient = new AccuWeatherApiClient(new OkHttpClient());
            String cityName = city.getText();

            FiveDayForecast fiveDayForecast = accuWeatherApiClient.getFiveDayForecast(cityName);
            TwelveHoursForecast twelveHoursForecast = accuWeatherApiClient.getTwelveHoursForecast(cityName);

            todayDayOfWeek.setText(LocalDate.now().getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
            todayIcon.setGlyphName(Icons.getGlyphName(fiveDayForecast.getDailyForecasts().get(0).getDay().getIconNumber()));
            description.setText(fiveDayForecast.getDailyForecasts().get(0).getDay().getShortPhrase());
            humidity.setText(twelveHoursForecast.getTwelveHoursForecast().get(0).getRelativeHumidity().toString());
            wind.setText(fiveDayForecast.getDailyForecasts().get(0).getDay().getWind().getSpeed().getValue().toString());
            temp.setText(twelveHoursForecast.getTwelveHoursForecast().get(0).getTemperature().getTemperature().toString());

            oneDayAfterDayOfWeek.setText(LocalDate.now().plusDays(1).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
            oneDayAfterIcon.setGlyphName(Icons.getGlyphName(fiveDayForecast.getDailyForecasts().get(1).getDay().getIconNumber()));
            oneDayAfterMaxTemp.setText(fiveDayForecast.getDailyForecasts().get(1).getTemperature().getMaximum().getValue().toString());
            oneDayAfterMinTemp.setText(fiveDayForecast.getDailyForecasts().get(1).getTemperature().getMinimum().getValue().toString());

            twoDayAfterDayOfWeek.setText(LocalDate.now().plusDays(2).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
            twoDayAfterIcon.setGlyphName(Icons.getGlyphName(fiveDayForecast.getDailyForecasts().get(2).getDay().getIconNumber()));
            twoDayAfterMaxTemp.setText(fiveDayForecast.getDailyForecasts().get(2).getTemperature().getMaximum().getValue().toString());
            twoDayAfterMinTemp.setText(fiveDayForecast.getDailyForecasts().get(2).getTemperature().getMinimum().getValue().toString());

            threeDayAfterDayOfWeek.setText(LocalDate.now().plusDays(3).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
            threeDayAfterIcon.setGlyphName(Icons.getGlyphName(fiveDayForecast.getDailyForecasts().get(3).getDay().getIconNumber()));
            threeDayAfterMaxTemp.setText(fiveDayForecast.getDailyForecasts().get(3).getTemperature().getMaximum().getValue().toString());
            threeDayAfterMinTemp.setText(fiveDayForecast.getDailyForecasts().get(3).getTemperature().getMinimum().getValue().toString());

            fourDayAfterDayOfWeek.setText(LocalDate.now().plusDays(4).getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).toUpperCase());
            fourDayAfterIcon.setGlyphName(Icons.getGlyphName(fiveDayForecast.getDailyForecasts().get(3).getDay().getIconNumber()));
            fourDayAfterMaxTemp.setText(fiveDayForecast.getDailyForecasts().get(4).getTemperature().getMaximum().getValue().toString());
            fourDayAfterMinTemp.setText(fiveDayForecast.getDailyForecasts().get(4).getTemperature().getMinimum().getValue().toString());

            moonRise.setText(fiveDayForecast.getDailyForecasts().get(0).getMoon().getRise().toLocalTime().toString());
            sunRise.setText(fiveDayForecast.getDailyForecasts().get(0).getSun().getRise().toLocalTime().toString());
            mainMinTemp.setText(fiveDayForecast.getDailyForecasts().get(0).getTemperature().getMinimum().getValue().toString());
            mainMaxTemp.setText(fiveDayForecast.getDailyForecasts().get(0).getTemperature().getMaximum().getValue().toString());

            AtomicInteger startIndex = new AtomicInteger();
            setHoursForecast(twelveHoursForecast, startIndex.get());


            buttonNext.setOnAction(actionEventNext -> {
                if (startIndex.get() < 8){
                    startIndex.set(startIndex.get() + 1);
                    setHoursForecast(twelveHoursForecast, startIndex.get());
                }
            });

            buttonBack.setOnAction(actionEventBack -> {
                if (startIndex.get() != 0) {
                    startIndex.set(startIndex.get() - 1);
                    setHoursForecast(twelveHoursForecast, startIndex.get());
                }
            });
        });

    }

    private void setHoursForecast(TwelveHoursForecast twelveHoursForecast, int startIndex) {
        timeOne.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex).getDateTime().toLocalTime().toString());
        timeOneIcon.setGlyphName(Icons.getGlyphName(twelveHoursForecast.getTwelveHoursForecast().get(startIndex).getWeatherIcon()));
        timeOneTemp.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex).getTemperature().getTemperature().toString());

        timeTwo.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 1).getDateTime().toLocalTime().toString());
        timeTwoIcon.setGlyphName(Icons.getGlyphName(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 1).getWeatherIcon()));
        timeTwoTemp.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 1).getTemperature().getTemperature().toString());

        timeThree.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 2).getDateTime().toLocalTime().toString());
        timeThreeIcon.setGlyphName(Icons.getGlyphName(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 2).getWeatherIcon()));
        timeThreeTemp.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 2).getTemperature().getTemperature().toString());

        timeFour.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 3).getDateTime().toLocalTime().toString());
        timeFourIcon.setGlyphName(Icons.getGlyphName(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 3).getWeatherIcon()));
        timeFourTemp.setText(twelveHoursForecast.getTwelveHoursForecast().get(startIndex + 3).getTemperature().getTemperature().toString());

    }
}

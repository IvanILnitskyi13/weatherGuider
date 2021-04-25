package controllers;

import de.jensd.fx.glyphs.weathericons.WeatherIconView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

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
    private WeatherIconView fourDayAfterIcon;

    @FXML
    private WeatherIconView fiveDayAfterIcon;

    @FXML
    private Text fourDayAfterMaxTemp;

    @FXML
    private Text foreDayAfterMinTemp;

    @FXML
    private Button getData;

    @FXML
    private Text oneDayAfterDayOfWeek;

    @FXML
    private WeatherIconView oneDayAfterIcon;

    @FXML
    private Text oneDeyAfterMaxTemp;

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
        getData.setOnAction(actionEvent -> {

        });

    }
}

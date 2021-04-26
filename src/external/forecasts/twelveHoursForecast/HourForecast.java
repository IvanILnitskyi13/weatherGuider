package external.forecasts.twelveHoursForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class HourForecast {

    @SerializedName("DateTime")
    private LocalDateTime dateTime;

    @SerializedName("WeatherIcon")
    private int weatherIcon;

    @SerializedName("Temperature")
    private Temperature temperature;

    @SerializedName("RelativeHumidity")
    private Integer relativeHumidity;
}

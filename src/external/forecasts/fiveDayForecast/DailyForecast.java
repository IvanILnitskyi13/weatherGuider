package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DailyForecast {

    @SerializedName("Date")
    private LocalDateTime date;

    @SerializedName("Sun")
    private Sun sun;

    @SerializedName("Moon")
    private Moon moon;

    @SerializedName("Temperature")
    private Temperature temperature;

    @SerializedName("RealFeelTemperature")
    private Temperature realFeelTemperature;

    @SerializedName("Day")
    private Day day;

    @SerializedName("Night")
    private Night night;
}

package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.List;

@Getter
@AllArgsConstructor
public class DailyForecasts {
    @SerializedName("DailyForecasts")
    private List<DailyForecast> dailyForecasts;
}

package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Speed {
    @SerializedName("Value")
    private Double value;
}

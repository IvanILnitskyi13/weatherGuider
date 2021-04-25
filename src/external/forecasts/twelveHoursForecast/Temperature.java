package external.forecasts.twelveHoursForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Temperature {

    @SerializedName("Value")
    private Double temperature;
}

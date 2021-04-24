package external.forecasts.twelveHoursForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
class Temperature {

    @SerializedName("Value")
    private Double temperature;
}

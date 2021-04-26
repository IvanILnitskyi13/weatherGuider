package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Wind {
    @SerializedName("Speed")
    private Speed speed;
}

package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class Moon {
    @SerializedName("Rise")
    private LocalDateTime rise;
    @SerializedName("Set")
    private LocalDateTime set;
}

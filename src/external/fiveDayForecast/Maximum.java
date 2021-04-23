package external.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Maximum {
    @SerializedName("Value")
    private Double value;
}

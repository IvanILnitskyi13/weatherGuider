package external.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Temperature {
    @SerializedName("Minimum")
    private Minimum minimum;

    @SerializedName("Maximum")
    private Maximum maximum;
}

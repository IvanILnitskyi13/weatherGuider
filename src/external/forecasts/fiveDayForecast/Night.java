package external.forecasts.fiveDayForecast;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Night {
    @SerializedName("Icon")
    private int iconNumber;
    @SerializedName("ShortPhrase")
    private String shortPhrase;
}
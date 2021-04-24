package external.forecasts;

public enum Icons {
    SUNNY(1, "DAY_SUNNY"),
    MOSTLY_SUNNY(2, "DAY_SUNNY_OVERCAST"),
    PARTLY_SUNNY(3, "DAY_SUNNY_OVERCAST"),
    INTERMITTENT_CLOUDS_DAY(4, "DAY_SUNNY_OVERCAST"),
    HAZY_SUNSHINE(5, "DAY_HAZE"),
    MOSTLY_CLOUDY_DAY(6, "DAY_CLOUDY_HIGH"),
    CLOUDY(7, "CLOUDY"),
    DREARY(8, "CLOUDY"),
    FOG(11, "FORECAST_IO_FOG"),
    SHOWERS(12, "FORECAST_IO_SLEET"),
    MOSTLY_CLOUDY_SHOWERS_DAY(13, "DAY_SHOWERS"),
    PARTLY_SUNNY_SHOWERS(14, "DAY_SHOWERS"),
    T_STORMS(15, "OWM_531"),
    MOSTLY_CLOUDY_T_STORMS_DAY(16, "DAY_SLEET_STORM"),
    PARTLY_SUNNY_T_STORMS(17, "DAY_SLEET_STORM"),
    RAIN(18, "FORECAST_IO_SLEET"),
    FLURRIES(19, "FORECAST_IO_SNOW"),
    MOSTLY_CLOUDY_FLURRIES_DAY(20, "DAY_SNOW_WIND"),
    PARTLY_SUNNY_FLURRIES(21, "DAY_SNOW_WIND"),
    SNOW(22, "FORECAST_IO_SNOW"),
    MOSTLY_CLOUDY_SNOW_DAY(23, "DAY_SNOW"),
    ICE(24, ""),
    SLEET(25, "FORECAST_IO_SLEET"),
    FREEZING_RAIN(26, "FORECAST_IO_SLEET"),
    RAIN_AND_SNOW(29, "OWM_616"),
    HOT(30, "THERMOMETER"),
    COLD(31, "THERMOMETER_EXTERIOR"),
    WINDY(32, "FORECAST_IO_WIND"),
    CLEAR(33, "NIGHT_CLEAR"),
    MOSTLY_CLEAR(34, "NIGHT_ALT_PARTLY_CLOUDY"),
    PARTLY_CLOUDY(35, "NIGHT_ALT_PARTLY_CLOUDY"),
    INTERMITTENT_CLOUDS_NIGHT(36, "NIGHT_ALT_PARTLY_CLOUDY"),
    HAZY_MOONLIGHT(37, "NIGHT_FOG"),
    MOSTLY_CLOUDY_NIGHT(38, "NIGHT_ALT_CLOUDY"),
    PARTLY_CLOUDY_SHOWERS(39, "OWM_NIGHT_521"),
    MOSTLY_CLOUDY_SHOWERS_NIGHT(40, "OWM_NIGHT_521"),
    PARTLY_CLOUDY_T_STORMS(41, "OWM_NIGHT_531"),
    MOSTLY_CLOUDY_T_STORMS_NIGHT(42, "OWM_NIGHT_531"),
    MOSTLY_CLOUDY_FLURRIES_NIGHT(43, "OWM_NIGHT_622"),
    MOSTLY_CLOUDY_SNOW_NIGHT(44, "OWM_NIGHT_622");

    private int iconNumber;
    private String glyphName;

    Icons(int iconNumber, String glyphsName) {
        this.iconNumber = iconNumber;
        this.glyphName = glyphsName;
    }

    public int getIconNumber() {
        return iconNumber;
    }

    public String getGlyphName() {
        return glyphName;
    }

    public String getGlyphName(int iconNumber) {
        for (Icons value : Icons.values()) {
            if (value.getIconNumber() == iconNumber) {
                return value.glyphName;
            }
        }
        return "INDEFINITE";
    }
}

package external;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import external.forecasts.fiveDayForecast.FiveDayForecast;
import external.forecasts.twelveHoursForecast.TwelveHoursForecast;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;

public class AccuWeatherApiClient {
    OkHttpClient okHttpClient;

    public AccuWeatherApiClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;


    }

    public FiveDayForecast getFiveDayForecast(String city) {
        Request rq = new Request.Builder().url("http://dataservice.accuweather.com/forecasts/v1/daily/5day/" +
                getCityKey(city) + "?apikey=NGPsQTr60QsmgW1WGK5uY1ZFvpsFRrx1&language=en-us&details=true&metric=true").build();
        try {
            Response response = okHttpClient.newCall(rq).execute();

            if (response.isSuccessful()) {
                String json = response.body().string();

                int startIndex = json.indexOf("\"Headline\"");
                int stopIndex = json.indexOf("\"DailyForecasts\"");
                StringBuilder builder = new StringBuilder(json);

                builder.delete(startIndex, stopIndex);

                return getGson().fromJson(builder.toString(), FiveDayForecast.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public TwelveHoursForecast getTwelveHoursForecast(String city) {
        Request rq = new Request.Builder().url("http://dataservice.accuweather.com/forecasts/v1/hourly/12hour/" +
                getCityKey(city) + "?apikey=NGPsQTr60QsmgW1WGK5uY1ZFvpsFRrx1&language=en-us&details=true&metric=true").build();
        try {
            Response response = okHttpClient.newCall(rq).execute();

            if (response.isSuccessful()) {
                String jsonTable = response.body().string();
                String jsonToDeserialize = "{ \"twelveHoursForecast\" : ".concat(jsonTable).concat("}");
                return  getGson().fromJson(jsonToDeserialize, TwelveHoursForecast.class);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private int getCityKey(String city) {

        Request rq = new Request.Builder().url("http://dataservice.accuweather.com/locations/v1/cities/search" +
                "?apikey=NGPsQTr60QsmgW1WGK5uY1ZFvpsFRrx1&q=" + city + "&language=en-us").build();
        try {
            Response response = okHttpClient.newCall(rq).execute();
            if (response.isSuccessful()) {
                String tableJson = response.body().string();
                String json = tableJson.substring(1, tableJson.length() - 1);
                JSONObject jsonObject = new JSONObject(json);
                return jsonObject.getInt("Key");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private Gson getGson() {
        return new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter())
                .create();
    }
}

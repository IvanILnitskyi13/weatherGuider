package external;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import org.json.JSONObject;

import java.io.IOException;

public class AccuWeatherApiClient {
    OkHttpClient okHttpClient;

    public AccuWeatherApiClient(OkHttpClient okHttpClient) {
        this.okHttpClient = okHttpClient;


    }

    public int getCityKey(String city) {

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
}

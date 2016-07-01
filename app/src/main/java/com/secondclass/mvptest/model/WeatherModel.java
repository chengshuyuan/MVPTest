package com.secondclass.mvptest.model;

import com.google.gson.Gson;
import com.secondclass.mvptest.bean.WeatherInfo;
import org.json.JSONObject;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherModel implements IWeatherModel {
    OkHttpClient client = new OkHttpClient();
    private WeatherInfo weatherInfo;
    @Override
    public void getWeather(String cityName, final GetWeatherListener listener) {

        final Request request = new Request.Builder()
                //这里只做一个模拟
                .url("http://www.weather.com.cn/data/cityinfo/101010100.html")
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.getFailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseStr = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(responseStr);
                    JSONObject weatherJson = jsonObject.optJSONObject("weatherinfo");
                    Gson gson = new Gson();
                    weatherInfo = gson.fromJson(weatherJson.toString(), WeatherInfo.class);
                    listener.getSuccess(weatherInfo);
                }catch (Exception e){
                    e.printStackTrace();
                    listener.getFailed();
                }
            }
        });

    }
}

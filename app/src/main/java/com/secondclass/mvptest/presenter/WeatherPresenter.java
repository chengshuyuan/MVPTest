package com.secondclass.mvptest.presenter;

import android.os.Handler;
import android.os.Looper;

import com.secondclass.mvptest.View.IWeatherView;
import com.secondclass.mvptest.bean.WeatherInfo;
import com.secondclass.mvptest.model.GetWeatherListener;
import com.secondclass.mvptest.model.IWeatherModel;
import com.secondclass.mvptest.model.WeatherModel;

public class WeatherPresenter {
    private IWeatherView weatherView;
    private IWeatherModel weatherModel;
    private Handler handler = new Handler(Looper.getMainLooper());

    public WeatherPresenter(IWeatherView weatherView){
        this.weatherModel = new WeatherModel();
        this.weatherView = weatherView;
    }

    public void getWeather(String cityName){
       weatherModel.getWeather(cityName, new GetWeatherListener() {
            @Override
            public void getSuccess(final WeatherInfo weatherInfo) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        weatherView.setWeather(weatherInfo);
                    }
                });
            }

            @Override
            public void getFailed() {

            }
        });
    }
}

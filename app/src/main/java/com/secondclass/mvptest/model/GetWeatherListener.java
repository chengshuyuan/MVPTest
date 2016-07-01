package com.secondclass.mvptest.model;

import com.secondclass.mvptest.bean.WeatherInfo;

public interface GetWeatherListener {
    void getSuccess(WeatherInfo weatherInfo);

    void getFailed();
}

package com.secondclass.mvptest.model;

public interface IWeatherModel {
    public void getWeather(String cityName, GetWeatherListener listener);
}

package com.secondclass.mvptest.bean;

public class WeatherInfo {
    private String city;
    private String cityid;
    private String temp1;
    private String temp2;
    private String weather;
    private String ptime;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityId() {
        return cityid;
    }

    public void setCityId(String cityId) {
        this.cityid = cityId;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String toString(){
        return city + temp1 + temp2 + weather + ptime;
    }
}

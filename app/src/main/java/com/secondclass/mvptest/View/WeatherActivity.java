package com.secondclass.mvptest.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.secondclass.mvptest.R;
import com.secondclass.mvptest.bean.WeatherInfo;
import com.secondclass.mvptest.presenter.WeatherPresenter;


public class WeatherActivity extends AppCompatActivity implements IWeatherView{

    private EditText et_cityName;
    private Button btn_submit;
    TextView tv_temp1, tv_temp2, tv_weather, tv_time;
    private String cityName;
    private WeatherPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        presenter = new WeatherPresenter(this);
        initView();
    }

    private void initView(){
        et_cityName = (EditText)this.findViewById(R.id.et_cityname);
        btn_submit = (Button)this.findViewById(R.id.btn_submit);
        tv_temp1 = (TextView)this.findViewById(R.id.tv_temp1);
        tv_temp2 = (TextView)this.findViewById(R.id.tv_temp2);
        tv_weather = (TextView)this.findViewById(R.id.tv_weather);
        tv_time = (TextView)this.findViewById(R.id.tv_time);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cityName = et_cityName.getText().toString().trim();
                if(!TextUtils.isEmpty(cityName)) {
                    presenter.getWeather(cityName);
                }
            }
        });
    }

    @Override
    public void setWeather(final WeatherInfo weatherInfo) {
        tv_temp1.setText(weatherInfo.getTemp1());
        tv_temp2.setText(weatherInfo.getTemp2());
        tv_weather.setText(weatherInfo.getWeather());
        tv_time.setText(weatherInfo.getPtime());
    }
}

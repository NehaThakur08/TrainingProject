package com.neha.application;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WeatherAdapter extends ArrayAdapter<Weather> {

    Context context;
    int resource;
    ArrayList<Weather> objects;

    public WeatherAdapter(Context context, int resource,  ArrayList<Weather> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(resource,parent,false);
        TextView txtTemperature = view.findViewById(R.id.textViewTemp);
        TextView txtPressure = view.findViewById(R.id.textViewPressure);
        TextView txtHumidity = view.findViewById(R.id.textViewHumidity);
        TextView txtMaxTemp = view.findViewById(R.id.textViewMaxTemp);
        TextView txtMinTemp = view.findViewById(R.id.textViewMinTemp);
        TextView txtSunrise = view.findViewById(R.id.textViewSunrise);
        TextView txtSunset = view.findViewById(R.id.textViewSunset);
        TextView txtName = view.findViewById(R.id.textViewName);

        Weather weather = objects.get(position);

        txtTemperature.setText(weather.temp);
        txtPressure.setText(weather.pressure);
        txtHumidity.setText(weather.humidity);
        txtMaxTemp.setText(weather.max_temp);
        txtMinTemp.setText(weather.min_temp);
        txtSunrise.setText(weather.sunrise);
        txtSunset.setText(weather.sunset);
        txtName.setText(weather.name);




        return view;
    }
}

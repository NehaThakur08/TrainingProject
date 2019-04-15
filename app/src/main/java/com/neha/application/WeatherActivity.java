package com.neha.application;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class WeatherActivity extends AppCompatActivity {
    ListView listView;
    String webServiceUrl;
    WeatherFetchTask task;
    ArrayList<Weather> weatherList;

    StringBuffer response;

    WeatherAdapter adapter;

    ProgressDialog progressDialog;

    void initViews() {
        listView = findViewById(R.id.listView);
        webServiceUrl = "https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22";

        //thread = new WeatherFetchThread();
        //thread.start();

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);

        task = new WeatherFetchTask();
        task.execute();


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initViews();
    }
    class WeatherFetchTask extends AsyncTask{



        @Override
        protected void onPreExecute() {
            progressDialog.show();

        }

        @Override
        protected void onPostExecute(Object o) {
           // Toast.makeText(WeatherActivity.this, response.toString().Toast.LENGTH_LONG).show();

            try {
                JSONObject jsonObject = new JSONObject(response.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("temp");
                weatherList = new ArrayList<>();
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jObj = jsonArray.getJSONObject(i);
                    // JSON Object is now represented as a Java Object
                    Weather weather = new Weather();
                    weather.temp = jObj.getString("temp");
                    weather.pressure = jObj.getInt("pressure");
                    weather.humidity = jObj.getInt("humidity");
                    weather.min_temp = jObj.getString("min_temp");
                    weather.max_temp = jObj.getString("max_temo");
                    weather.sunrise = jObj.getInt("sunrise");
                    weather.sunset = jObj.getInt("sunset");
                    weather.name = jObj.getString("name");


                    weatherList.add(weather);
                }

                adapter = new WeatherAdapter(WeatherActivity.this,R.layout.weather_list_item,weatherList);
                    listView.setAdapter(adapter);

                    progressDialog.dismiss();

                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        @Override
        protected Object doInBackground(Object[] objects) {
            try{

                // URL to Web Service
                URL url = new URL(webServiceUrl);

                // Create a Connection between Client and Server
                URLConnection urlConnection = url.openConnection();

                // Read Data from WebService on Server
                InputStream inputStream = urlConnection.getInputStream();

                // To Read Data Line By Line
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                // response contains JSON Data from WebService
                response = new StringBuffer();

                String line = "";
                while ((line = bufferedReader.readLine())!=null){
                    response.append(line);
                }

            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }

        }




    }


package com.neha.application;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SensorsActivity extends AppCompatActivity implements SensorEventListener {

    TextView txtSensor;
    Button btnShake;
    SensorManager sensorManager;
    Sensor sensor;

    void initViews() {
        txtSensor = findViewById(R.id.textViewSensor);
        btnShake = findViewById(R.id.buttonShake);
        btnShake.setOnClickListener(clickListener);

        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

    }

    View.OnClickListener clickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            sensorManager.registerListener(SensorsActivity.this, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensors);
        initViews();
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        float[] values = event.values;

        /*float x = values[0];
        float y = values[1];
        float z = values[2];
        //txtData.setText(x+":"+y+":"+z);
        float calculation = ((x*x)+(y*y)+(z*z)) / (SensorManager.GRAVITY_EARTH*SensorManager.GRAVITY_EARTH);
        if(calculation>2){
            txtData.setText("Shake Detected");
            sensorManager.unregisterListener(this);
            // LocationManager : Assignment*
        }else{
            txtData.setText(x+" : "+y+" : "+z);
        }*/

        float proximityValue = values[0];
        txtSensor.setText("Proximity Value: " + proximityValue);


        if (proximityValue == 0.0) {
            Intent intent = new Intent(Intent.ACTION_CALL);
            intent.setData(Uri.parse("tel:+91 9501577391"));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(SensorsActivity.this, "Please Grant Permissions", Toast.LENGTH_LONG).show();
            } else {
                startActivity(intent);
            }
        }


    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sensorManager.unregisterListener(this);
    }
}

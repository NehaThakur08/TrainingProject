package com.neha.farmingproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LocaleFarmActivity extends AppCompatActivity {

    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale_farm);
        txt = findViewById(R.id.textViewTitle);
        // Dynamically how we can set the String
        txt.setText(getResources().getString(R.string.titleRegister));
    }
}

package com.neha.farmingproject;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neha.farmingproject.ui.LanguageActivity;
import com.neha.farmingproject.ui.RegistrationActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        handler.sendEmptyMessageDelayed(101, 2000);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 101) {
                Intent intent = new Intent(SplashActivity.this, LanguageActivity.class);
                startActivity(intent);
                finish();
            }

            }

    };
}


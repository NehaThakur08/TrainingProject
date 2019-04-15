package com.neha.farmingproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.neha.farmingproject.HomeDashboardActivity;
import com.neha.farmingproject.R;

public class RegistrationActivity extends AppCompatActivity {

    EditText eTxtPhone;
    Button btnSend;



    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eTxtPhone = findViewById(R.id.editTextPhone);
        btnSend = findViewById(R.id.buttonSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HomeDashboardActivity.class);
                startActivity(intent);

            }
        });


    }

}

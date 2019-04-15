package com.neha.trainingproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class RegistrationActivity extends AppCompatActivity {
    EditText eTxtName, eTxtPhone, eTxtPassword;
    Button btnRegister;

    String data;
    String name;
    String phone;
    String password;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;


    void initView() {
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);
        eTxtPassword = findViewById(R.id.editTextPassword);
        btnRegister = findViewById(R.id.buttonRegister);

        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name = eTxtName.getText().toString();
                String Phone = eTxtPhone.getText().toString();
                String Password = eTxtPassword.getText().toString();

                editor.putString("keyname", Name);
                editor.putString("keyphone", Phone);
                editor.putString("keypassword", Password);

                sharedPreferences.edit().apply(); // Save the Data in XML File | Background Thread
                editor.commit();  // Save the Data in XML File

                Toast.makeText(RegistrationActivity.this, "Data Saved in SharedPrefs", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
                startActivity(intent);
                eTxtName.setText("");
                eTxtPhone.setText("");
                eTxtPassword.setText("");


//
//
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

//        data = sharedPreferences.getString("keyQuote","null");
//        eTxtName.setText(data);
//        eTxtPhone.setText(data);
//        eTxtPassword.setText(data);

//

        Intent intent = new Intent(RegistrationActivity.this, HomeActivity.class);
        if (sharedPreferences.contains("keyname")) {

            startActivity(intent);
        }


    }
}




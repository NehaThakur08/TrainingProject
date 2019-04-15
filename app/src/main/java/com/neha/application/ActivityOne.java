package com.neha.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActivityOne extends AppCompatActivity implements View.OnClickListener{

    EditText eTxtName, eTxtPhone;
    Button btnSubmit;
    void initViews() {
        eTxtName = findViewById(R.id.editTextName);
        eTxtPhone = findViewById(R.id.editTextPhone);

        btnSubmit = findViewById(R.id.buttonSubmit);
        btnSubmit.setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        initViews();
    }

    @Override
    public void onClick(View v) {
//       Person person = new Person();
//        person.name = eTxtName.getText().toString();
//        person.phone = eTxtPhone.getText().toString();

//        Intent intent = new Intent(ActivityOne.this, ActivityTwo2.class);
//        intent.putExtra("keyName",name);
//        intent.putExtra("KeyPhone",phone);
//        Bundle bundle = new Bundle(());
//        bundle.putString("keyName",name);
//        bundle.putString("keyPhone", phone);
//        bundle.putInt("Age", 30);


//        intent.putExtra("keyPerson",person);
//        startActivity(intent);
        Intent intent = new Intent(ActivityOne.this, ActivityTwo2.class);
    startActivityForResult(intent, 101);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 101 && resultCode == 201){
            String name = data.getStringExtra("keyName");
            String phone = data.getStringExtra("keyPhone");

            eTxtName.setText(name);
            eTxtPhone.setText(phone);

        }
    }
}

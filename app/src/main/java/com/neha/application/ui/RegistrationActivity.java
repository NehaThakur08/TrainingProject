package com.neha.application.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.neha.application.Home1Activity;
import com.neha.application.R;
import com.neha.application.model.User;
import com.neha.application.model.Util;

public class RegistrationActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtLogin;

    EditText eTxtName, eTxtEmail, eTxtPassword;
    Button btnRegister;
    User user;

    FirebaseAuth auth;
    FirebaseFirestore db;
    FirebaseUser firebaseUser;
    ProgressDialog progressDialog;

    void initViews() {
        eTxtName = findViewById(R.id.editTextName);
        eTxtEmail = findViewById(R.id.editTextEmailAdd);
        eTxtPassword = findViewById(R.id.editTextPassword);
        txtLogin = findViewById(R.id.textViewLogin);

        btnRegister = findViewById(R.id.buttonRegister);
        btnRegister.setOnClickListener(this);
        txtLogin.setOnClickListener(this);


        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        user = new User();
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initViews();
    }

    @Override
    public void onClick(View v) {

        int id = v.getId();

        if (id == R.id.buttonRegister) {
            user.name = eTxtName.getText().toString();
            user.email = eTxtEmail.getText().toString();
            user.password = eTxtPassword.getText().toString();

            if(Util.isInternetConnected(this)) {
                registerUser();
            }else{
                Toast.makeText(this,"Please Connect to Internet and Try Again",Toast.LENGTH_LONG).show();
            }
        } else {
            Intent intent = new Intent(RegistrationActivity.this, Home1Activity.class);
            startActivity(intent);
        }

    }

    void registerUser() {

        progressDialog.show();
        auth.createUserWithEmailAndPassword(user.email, user.password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isComplete()) {
//                            Toast.makeText(RegistrationActivity.this, user.name+ "Register Successfully!!", Toast.LENGTH_LONG).show();
//                            progressDialog.dismiss();
//
//                            Intent intent = new Intent(RegistrationActivity.this, Home1Activity.class);
//                            startActivity(intent);
//                            finish();
                            saveUserInCloudDB();

                        }
                    }
                });
    }

   void saveUserInCloudDB() {

//            db.collection("users").add(user)
//                    .addOnCompleteListener(this, new OnCompleteListener<DocumentReference>() {
//                        @Override
//                        public void onComplete(@NonNull Task<DocumentReference> task) {
//                            if(task.isComplete()){
//                                Toast.makeText(RegistrationActivity.this,user.name+ "Registered Sucessfully", Toast.LENGTH_LONG).show();
//                                progressDialog.dismiss();
//
//                                Intent intent = new Intent(RegistrationActivity.this, Home1Activity.class);
//                                startActivity(intent);
//                                finish();
//
//                            }
//    }
//                    });

       //To create the same hashcode in Authentication and Database
        firebaseUser = auth.getCurrentUser();
        db.collection("users").document(firebaseUser.getUid()).set(user)
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(RegistrationActivity.this,user.name+ "Registered Sucessfully", Toast.LENGTH_LONG).show();
                        progressDialog.dismiss();

                        Intent intent = new Intent(RegistrationActivity.this, AddCustomerActivity.class);
                        startActivity(intent);
                        finish();

                    }

   });

                    }




    }



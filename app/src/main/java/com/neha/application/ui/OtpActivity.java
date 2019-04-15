package com.neha.application.ui;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.neha.application.Home1Activity;
import com.neha.application.R;

import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OtpActivity extends AppCompatActivity {

    @BindView(R.id.editTextPhone)
    EditText eTxtPhone;

//    @BindView(R.id.editTextOtp)
//    EditText eTxtOtp;

    @BindView(R.id.buttonVerify)
    Button btnVerify;


    PhoneAuthProvider authProvider;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
//eTxtOtp.setVisibility(View.INVISIBLE);
        ButterKnife.bind(this);
        btnVerify.setOnClickListener(clickListener);

        authProvider = PhoneAuthProvider.getInstance();
        auth = FirebaseAuth.getInstance();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String phone = eTxtPhone.getText().toString().trim();

            authProvider.verifyPhoneNumber(
                    phone,
                    60,
                    TimeUnit.SECONDS,
                    OtpActivity.this,
                    callbacks);
        }
    };

    PhoneAuthProvider.OnVerificationStateChangedCallbacks callbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            // You can fetch OTP and can validate by asking from user in other EditText in case
            String otp = phoneAuthCredential.getSmsCode();
            signInUser(phoneAuthCredential);
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(OtpActivity.this,"OTP Verification Failed"+e.getMessage(),Toast.LENGTH_LONG).show();

        }
    };

    void signInUser(PhoneAuthCredential phoneAuthCredential){
       auth.signInWithCredential(phoneAuthCredential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
           @Override
           public void onComplete(@NonNull Task<AuthResult> task) {
               if(task.isComplete()){
                   FirebaseUser user = task.getResult().getUser();
                   String userId = user.getUid();
                   Intent intent = new Intent(OtpActivity.this, Home1Activity.class);
                   startActivity(intent);
                   finish();
               }
           }
       });
           }

    }


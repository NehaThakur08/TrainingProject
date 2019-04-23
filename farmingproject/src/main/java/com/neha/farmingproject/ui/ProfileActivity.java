package com.neha.farmingproject.ui;

import android.app.ProgressDialog;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import com.neha.farmingproject.R;
import com.neha.farmingproject.model.Profile;
import com.neha.farmingproject.model.Util;


public class ProfileActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    EditText eTxtName, eTxtEmail, eTxtAge;
    Button btnSave;
    Profile profile;


    ContentResolver contentResolver;
    FirebaseAuth auth;
    FirebaseFirestore db;
    FirebaseUser firebaseUser;
    boolean updateMode;

    private Spinner spinner;
    private static final String[] paths = {"Gender","Male", "Female"};


    void initViews() {

        contentResolver = getContentResolver();

        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        firebaseUser = auth.getCurrentUser();

        eTxtName = findViewById(R.id.editTextName);
        eTxtEmail = findViewById(R.id.editTextEmail);
        eTxtAge = findViewById(R.id.editTextAge);
        btnSave =  findViewById(R.id.buttonSave);

        profile = new Profile();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                profile.name = eTxtName.getText().toString();
                profile.email = eTxtEmail.getText().toString();
                profile.age = eTxtAge.getText().toString();

                //addCustomerInDB();
                if (Util.isInternetConnected(ProfileActivity.this)) {
                    saveCustomerInCloudDB();
                } else {
                    // give message
                }

            }
        });
        Intent rcv = getIntent();
        updateMode = rcv.hasExtra("keyCustomer");

        if(updateMode){
            profile = (Profile) rcv.getSerializableExtra("keyCustomer");
            eTxtName.setText(profile.name);
            eTxtEmail.setText(profile.email);
            eTxtAge.setText(profile.age);
            btnSave.setText("Update Customer");
        }

    }

    void addCustomerInDB() {

        ContentValues values = new ContentValues();
        values.put(Util.COL_NAME, profile.name);
        values.put(Util.COL_EMAIL, profile.email);
        values.put(Util.COL_AGE, profile.age);

        if (updateMode) {

            String where = Util.COL_ID + " = " + profile.id;
            int i = contentResolver.update(Util.Users_URI, values, where, null);
            if (i > 0) {
                Toast.makeText(this, "Updation Finished", Toast.LENGTH_LONG).show();
                finish();
            } else {
                Toast.makeText(this, "Updation Failed", Toast.LENGTH_LONG).show();
            }

        } else {


            Uri uri = contentResolver.insert(Util.Users_URI, values);
            Toast.makeText(this, profile.name + " Added in Database: " + uri.getLastPathSegment(), Toast.LENGTH_LONG).show();

            clearFields();
        }
    }


            void saveCustomerInCloudDB () {
                if(updateMode){
                    db.collection("users").document(firebaseUser.getUid())
                            .collection("customers").document(profile.docId)
                            .set(profile)
                            .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if(task.isComplete()){
                                        Toast.makeText(ProfileActivity.this,"Updation Finished",Toast.LENGTH_LONG).show();
                                        finish();
                                    }else{
                                        Toast.makeText(ProfileActivity.this,"Updation Failed",Toast.LENGTH_LONG).show();
                                    }
                                }
                            });

                }else {
                }
                db.collection("users").document(firebaseUser.getUid())
                        .collection("user").add(profile)
                        .addOnCompleteListener(this, new OnCompleteListener<DocumentReference>() {
                            @Override
                            public void onComplete(@NonNull Task<DocumentReference> task) {
                                if (task.isComplete()) {
                                    Toast.makeText(
                                            ProfileActivity.this, "Information Saved", Toast.LENGTH_LONG).show();
                                    clearFields();
                                }
                            }


                        });

            }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        spinner = (Spinner)findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ProfileActivity.this,
                android.R.layout.simple_spinner_item,paths);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        initViews();

    }



    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
                // Whatever you want to happen when the first item gets selected
                break;
            case 1:
                // Whatever you want to happen when the second item gets selected
                break;
            case 2:
                // Whatever you want to happen when the second item gets selected
                break;

        }

}

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    void clearFields(){
        eTxtName.setText("");
        eTxtEmail.setText("");
        eTxtAge.setText("");

    }
}

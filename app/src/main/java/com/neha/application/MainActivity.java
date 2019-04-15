package com.neha.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Binding the Layout on Activity
        // MainActivity is an Empty Frame which shall look like the layout you have designed
        setContentView(R.layout.activity_main);

        //System.out.println("(A1) : onCreate");
        Log.i(TAG,"==onStart==");

    }
    @Override
    protected void onStart() {
        super.onStart();
        //System.out.println("(A1) : onStart");
        Log.i(TAG,"==onStart==");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //System.out.println("(A1) : onResume");
        Log.i(TAG,"==onResume==");
    }

    @Override
    protected void onPause() {
        super.onPause();
        //System.out.println("(A1) : onPause");
        Log.i(TAG,"==onPause==");
    }

    @Override
    protected void onStop() {
        super.onStop();
        //System.out.println("(A1) : onStop");
        Log.i(TAG,"==onStop==");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //System.out.println("(A1) : onDestroy");
        Log.i(TAG,"==onDestroy==");
    }

    // clickHandler name can be any name
    public void clickHandler(View view){

        // Implicit Intent
        //Intent intent = new Intent("com.neha.application.home1activity");

        // Explicit Intent
        Intent intent = new Intent(MainActivity.this, Home1Activity.class);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //Explicit Menu
        menu.add(1,101,0,"CNN");
        menu.add(2,201,0,"NDTV");
        menu.add(3,301,0,"AAJ Tak");
        menu.add(4,401,0,"PTC");
        //getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        if(itemId == 101){
            Intent intent = new Intent(MainActivity.this, Home1Activity.class);
            startActivity(intent);
        }else if(itemId == 201){
        }else if(itemId == 301){
        }else if(itemId == 401){
        }else {
        }

        return super.onOptionsItemSelected(item);
    }
}




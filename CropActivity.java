package com.neha.farmingproject.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.neha.farmingproject.R;

public class CropActivity extends AppCompatActivity {
    ImageView imgbarley, imgsugar, imgtomato, imgcauli, imgcotton, imgmaize, imgwheat, imgmustard, imgrice, imgoats, imgonion, imgpotato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crop);

        imgbarley = findViewById(R.id.barley);
        imgbarley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), BarleyActivity.class);
                startActivity(intent);
            }
        });

        imgcauli = findViewById(R.id.cauli);
        imgcauli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CauliflowerActivity.class);
                startActivity(intent);
            }
        });
        imgcotton = findViewById(R.id.cotton);
        imgcotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CottonActivity.class);
                startActivity(intent);
            }
        });
        imgmaize = findViewById(R.id.maize);
        imgmaize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MaizeActivity.class);
                startActivity(intent);

            }
        });
        imgmustard = findViewById(R.id.mustard);
        imgmustard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MustardActivity.class);
                startActivity(intent);
            }
        });
        imgoats = findViewById(R.id.oats);
        imgoats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OatsActivity.class);
                startActivity(intent);
            }
        });
        imgonion = findViewById(R.id.onion);
        imgonion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OnionActivity.class);
                startActivity(intent);
            }
        });
        imgpotato = findViewById(R.id.potato);
        imgpotato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PotatoActivity.class);
                startActivity(intent);
            }
        });

        imgrice= findViewById(R.id.rice);
        imgrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RiceActivity.class);
                startActivity(intent);
            }
        });
        imgsugar = findViewById(R.id.sugarcane);
        imgsugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SugarcaneActivity.class);
                startActivity(intent);
            }
        });
        imgtomato = findViewById(R.id.tomato);
        imgtomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), TomatoActivity.class);
                startActivity(intent);
            }
        });

        imgwheat = findViewById(R.id.wheat);
        imgwheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WheatActivity.class);
                startActivity(intent);
            }
        });

    }

    }


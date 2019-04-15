package com.neha.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class PlayMusicActivity extends AppCompatActivity {
    ListView listView;
    ArrayAdapter<String> adapter;

    String path;

    void initViews(){
        listView = findViewById(R.id.listView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
    }
}

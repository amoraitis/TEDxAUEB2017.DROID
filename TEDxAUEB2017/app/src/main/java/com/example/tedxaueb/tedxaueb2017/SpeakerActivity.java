package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import Models.Speaker;

/**
 * Created by tasos on 3/1/2017.
 */

public class SpeakerActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speaker);
        Intent i = getIntent();
        Speaker myspeaker = (Speaker)i.getSerializableExtra("Speaker");
        this.setTitle(myspeaker.getName());
    }
}

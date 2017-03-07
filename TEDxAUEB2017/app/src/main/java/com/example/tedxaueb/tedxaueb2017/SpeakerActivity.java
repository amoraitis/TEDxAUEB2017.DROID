package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

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
        ImageView largephoto = (ImageView) findViewById(R.id.largespeaker);
        largephoto.setImageResource(myspeaker.getLargeImg());
        TextView aboutspeaker = (TextView)findViewById(R.id.aboutspeaker);
        aboutspeaker.setText(myspeaker.getLargeImg());
    }
}

package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

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
        final Speaker myspeaker = (Speaker)i.getSerializableExtra("Speaker");
        ImageView largephoto = (ImageView) findViewById(R.id.largespeaker);
        TextView aboutspeaker = (TextView)findViewById(R.id.aboutspeaker);
        Button learnmore = (Button) findViewById(R.id.learnmore);
        this.setTitle(myspeaker.getName());
        GlideDrawableImageViewTarget mosaicViewTarget = new GlideDrawableImageViewTarget(largephoto);
        Glide.with(this).load(myspeaker.getLargeImg()).into(mosaicViewTarget);
        aboutspeaker.setText(myspeaker.getBio());
        learnmore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(myspeaker.getMoreLink())));
            }
        });
    }
}

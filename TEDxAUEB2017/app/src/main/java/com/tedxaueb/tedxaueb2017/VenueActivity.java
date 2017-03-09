package com.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import Helpers.FontManager;

/**
 * Created by tasos on 2/27/2017.
 */

public class VenueActivity extends AppCompatActivity {
    ImageView gifView;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.venue);
        gifView = (ImageView) findViewById(R.id.venuegif);
        GlideDrawableImageViewTarget imageViewTarget = new GlideDrawableImageViewTarget(gifView);
        Glide.with(this).load(R.drawable.venue).into(imageViewTarget);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.direct),iconFont);
        ((Button)findViewById(R.id.direct)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.gr/maps/place/INNOVATHENS/@37.9780906,23.7121083,17z/data=!3m1!4b1!4m5!3m4!1s0x14a1bcdf95bf8323:0x280e1f4e6f0af096!8m2!3d37.9780906!4d23.714297")));
            }
        });
    }
}

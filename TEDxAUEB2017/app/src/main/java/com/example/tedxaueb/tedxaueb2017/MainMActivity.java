package com.example.tedxaueb.tedxaueb2017;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import Helpers.FontManager;

public class MainMActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Typeface iconFont = FontManager.getTypeface(getApplicationContext(), FontManager.FONTAWESOME);
        FontManager.markAsIconContainer(findViewById(R.id.socialicons),iconFont);
        ((ImageButton)findViewById(R.id.gomosaic)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMActivity.this, AboutMosaicActivity.class);
                startActivity(i);
            }
        });
        ((ImageButton)findViewById(R.id.speakersbtn)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMActivity.this, SpeakersActivity.class);
                startActivity(i);
            }
        });
        ((ImageButton)findViewById(R.id.Venue)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMActivity.this, VenueActivity.class);
                startActivity(i);
            }
        });
        ((Button)findViewById(R.id.FacebookButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(newFacebookIntent(getPackageManager(),"https://www.facebook.com/TEDxAUEB/")));
            }
        });
        ((Button)findViewById(R.id.InstagramButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("http://instagram.com/_u/tedxaueb");
                Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

                likeIng.setPackage("com.instagram.android");

                try {
                    startActivity(likeIng);
                } catch (ActivityNotFoundException e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://instagram.com/tedxaueb")));
                }            }
        });
        ((Button)findViewById(R.id.YoutubeButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/user/tedxaueb")));

            }
        });
        ((Button)findViewById(R.id.TwitterButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("twitter://user?screen_name=tedxaueb"));
                    startActivity(intent);

                }catch (Exception e) {
                    startActivity(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://twitter.com/#!/tedxaueb")));
                }
            }
        });
        ((Button)findViewById(R.id.LinkedInButton)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*try {
                    getPackageManager().getPackageInfo("com.linkedin.android", 0);
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("linkedin://profile/2802636"));
                }catch (Exception e) {

                }*/
                Intent liIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/company/tedxaueb"));
                startActivity(liIntent);
            }
        });
    }

    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
    }
}

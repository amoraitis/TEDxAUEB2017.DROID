package com.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/**
 * Created by tasos on 2/28/2017.
 */

public class AboutMosaicActivity extends AppCompatActivity {
    ImageView mosaicgif;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutmosaic);
        mosaicgif = (ImageView) findViewById(R.id.mosaicgif);
        GlideDrawableImageViewTarget mosaicViewTarget = new GlideDrawableImageViewTarget(mosaicgif);
        Glide.with(this).load(R.drawable.giasitenewest).into(mosaicViewTarget);
        TextView aboutmtxt = (TextView)findViewById(R.id.mosaictxt);
        aboutmtxt.setText("\"A mosaic is a piece of art or image made from the assemblage of small pieces.\" But, could we verge on mosaic's meaning from different perspectives?\n" +
                "\n" +
                "The mosaic of civilizations, cities, society, human body, beauty standards and the whole planet are only some of the those perspectives.\n" +
                "\n" +
                "TEDxAUEB is back for its 5th year, on March 18th at Techopolis City of Athens, with 12 unique speakers from different fields of expertise, who are going to give their own definition about mosaic, inspired performances and interactive workshops.");
        ((Button)findViewById(R.id.lrnmore)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://2017.tedxaueb.com/")));
            }
        });
    }
}

package com.example.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.LinkedList;

import Helpers.HandleSponsors;
import Helpers.SponsorsAdapter;
import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class SponsorsActivity extends AppCompatActivity {
    ImageView auspices, academic;
    GridView platinumGrid, goldGrid, silverGrid,friendsGrid,inkindGrid,mediaGrid;
    HandleSponsors handlingLikeABoss;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlingLikeABoss = new HandleSponsors();
        setContentView(R.layout.sponsors);
        auspices = (ImageView)findViewById(R.id.auspices);
        academic = (ImageView)findViewById(R.id.academic);
        platinumGrid = (GridView) findViewById(R.id.platinumGrid);
        goldGrid = (GridView) findViewById(R.id.goldGrid);
        silverGrid = (GridView) findViewById(R.id.silverGrid);
        friendsGrid = (GridView) findViewById(R.id.friendsGrid);
        inkindGrid = (GridView) findViewById(R.id.inkindGrid);
        mediaGrid = (GridView) findViewById(R.id.mediaGrid);
        //avoid nested scrolls
        platinumGrid.setOnTouchListener(myTouchClickListener);
        goldGrid.setOnTouchListener(myTouchClickListener);
        silverGrid.setOnTouchListener(myTouchClickListener);
        friendsGrid.setOnTouchListener(myTouchClickListener);
        inkindGrid.setOnTouchListener(myTouchClickListener);
        mediaGrid.setOnTouchListener(myTouchClickListener);
    }


    View.OnTouchListener myTouchClickListener = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            return event.getAction()==MotionEvent.ACTION_MOVE;
        }
    };

    private void setAdaptersAndSingles(){
        //set Singles
        GlideDrawableImageViewTarget academicHandler = new GlideDrawableImageViewTarget(academic);
        Glide.with(this).load(handlingLikeABoss.getAcademic().getImage()).into(academicHandler);
        GlideDrawableImageViewTarget auspicesHandler = new GlideDrawableImageViewTarget(auspices);
        Glide.with(this).load(handlingLikeABoss.getAuspices().getImage()).into(auspicesHandler);
        //setAdapters
        platinumGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getPlatinum()));
        goldGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getGold()));
        silverGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getSilver()));
        friendsGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getFriends()));
        inkindGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getInkind()));
        mediaGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getMedia()));
    }

    private void setOnClickListeners(){
        //for singles
        auspices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sponsor my = (Sponsor)handlingLikeABoss.getAuspices();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        academic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Sponsor my = (Sponsor)handlingLikeABoss.getAcademic();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });


        //for gridviews
        platinumGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getPlatinum().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));

            }
        });
        goldGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getGold().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        silverGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getSilver().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        friendsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getFriends().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        inkindGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getInkind().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        mediaGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getMedia().get(position);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });

    }

}

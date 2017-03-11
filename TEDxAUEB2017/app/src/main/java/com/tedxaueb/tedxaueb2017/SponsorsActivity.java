package com.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import Helpers.ExpandableHeightGridView;
import Helpers.HandleSponsors;
import Helpers.SponsorsAdapter;
import Models.Sponsor;

/**
 * Created by tasos on 3/8/2017.
 */

public class SponsorsActivity extends AppCompatActivity {
    ImageView auspices, academic;
    ExpandableHeightGridView platinumGrid, goldGrid, silverGrid,friendsGrid,inkindGrid, workshopsGrid,mediaGrid,communityGrid;
    HandleSponsors handlingLikeABoss;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handlingLikeABoss = new HandleSponsors();
        setContentView(R.layout.sponsors);
        auspices = (ImageView)findViewById(R.id.auspices);
        academic = (ImageView)findViewById(R.id.academic);
        platinumGrid = (ExpandableHeightGridView ) findViewById(R.id.platinumGrid);
        goldGrid = (ExpandableHeightGridView ) findViewById(R.id.goldGrid);
        silverGrid = (ExpandableHeightGridView ) findViewById(R.id.silverGrid);
        friendsGrid = (ExpandableHeightGridView ) findViewById(R.id.friendsGrid);
        inkindGrid = (ExpandableHeightGridView) findViewById(R.id.inkindGrid);
        communityGrid=(ExpandableHeightGridView)findViewById(R.id.communityGrid);
        workshopsGrid=(ExpandableHeightGridView)findViewById(R.id.workshopsGrid) ;
        mediaGrid = (ExpandableHeightGridView) findViewById(R.id.mediaGrid);
        setAdaptersAndSingles();
        setOnClickListeners();
        //avoid nested scrolls
        //platinumGrid.setOnTouchListener(myTouchClickListener);
        //goldGrid.setOnTouchListener(myTouchClickListener);
        //silverGrid.setOnTouchListener(myTouchClickListener);
        //friendsGrid.setOnTouchListener(myTouchClickListener);
        //inkindGrid.setOnTouchListener(myTouchClickListener);
        //mediaGrid.setOnTouchListener(myTouchClickListener);
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
        communityGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getCommunity()));
        workshopsGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getWorkshops()));
        mediaGrid.setAdapter(new SponsorsAdapter(this,handlingLikeABoss.getMedia()));
        platinumGrid.setExpanded(true);
        goldGrid.setExpanded(true);
        silverGrid.setExpanded(true);
        friendsGrid.setExpanded(true);
        inkindGrid.setExpanded(true);
        communityGrid.setExpanded(true);
        workshopsGrid.setExpanded(true);
        mediaGrid.setExpanded(true);
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
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));

            }
        });
        goldGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getGold().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        silverGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getSilver().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        friendsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getFriends().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        inkindGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getInkind().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        workshopsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = handlingLikeABoss.getWorkshops().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(my.getSite())));
            }
        });
        mediaGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getMedia().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
        communityGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Sponsor my = (Sponsor)handlingLikeABoss.getCommunity().get(position);
                if(!my.getSite().equals(""))
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(my.getSite())));
            }
        });
    }

}
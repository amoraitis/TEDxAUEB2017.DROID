package com.tedxaueb.tedxaueb2017;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import Helpers.HandleSpeakers;
import Helpers.SpRecyclerViewAdapter;
import Models.Speaker;

/**
 * Created by tasos on 2/27/2017.
 */

public class SpeakersActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private LinkedList<Speaker> myspeakers = (new HandleSpeakers()).getMyspeakers();
    private static String LOG_TAG = "CardViewActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speakers);
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new SpRecyclerViewAdapter(myspeakers);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);

        // Code to Add an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).addItem(obj, index);

        // Code to remove an item with default animation
        //((MyRecyclerViewAdapter) mAdapter).deleteItem(index);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ((SpRecyclerViewAdapter) mAdapter).setOnItemClickListener(new SpRecyclerViewAdapter
                .MyClickListener() {
            @Override
            public void onItemClick(int position, View v) {
                Speaker o = (Speaker)myspeakers.get(position);
                Intent speaker = new Intent(SpeakersActivity.this,SpeakerActivity.class);
                speaker.putExtra("Speaker", (Serializable) o);
                startActivity(speaker);
            }
        });
    }



}

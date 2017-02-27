package com.example.tedxaueb.tedxaueb2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import Helpers.SpeakersListAdapter;
import Models.Speaker;

/**
 * Created by tasos on 2/27/2017.
 */

public class SpeakersActivity extends AppCompatActivity {
    List<Speaker> speakers;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.speakers);
        SpeakersParser gsp =new SpeakersParser();
        speakers = gsp.getSpeakers();
        final ListView listView = (ListView) findViewById(R.id.SpListView);
        listView.setAdapter(new SpeakersListAdapter(this,speakers));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o =listView.getItemAtPosition(position);
                Speaker speakerData = (Speaker)o;
                Toast.makeText(SpeakersActivity.this,"Selected :"+" "+speakerData,Toast.LENGTH_LONG).show();
            }
        });

    }

}

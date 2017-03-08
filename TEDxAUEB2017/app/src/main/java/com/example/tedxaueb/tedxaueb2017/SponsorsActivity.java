package com.example.tedxaueb.tedxaueb2017;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import Helpers.SponsorsAdapter;

/**
 * Created by tasos on 3/8/2017.
 */

public class SponsorsActivity extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sponsors);

        GridView gridview = (GridView) findViewById(R.id.grid);
        gridview.setAdapter(new SponsorsAdapter(this,(new Helpers.HandleSponsors()).getSponsors()));

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(SponsorsActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();
            }
        });
        //avoid nested scrolls
        gridview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return event.getAction()==MotionEvent.ACTION_MOVE;
            }
        });
    }

}

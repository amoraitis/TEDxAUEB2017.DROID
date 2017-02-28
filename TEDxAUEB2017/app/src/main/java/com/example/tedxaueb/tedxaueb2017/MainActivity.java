package com.example.tedxaueb.tedxaueb2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.premain);
        //MobileCenter.start(getApplication(), "fb3ef734-0989-4973-93ce-331f9e137395", Analytics.class, Crashes.class);
        Button cancel =(Button) findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent i = new Intent(MainActivity.this, MainMActivity.class);
                startActivity(i);
            }
        });
        ((Button)findViewById(R.id.play)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginI = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(loginI);
            }
        });
    }
}

package com.example.tedxaueb.tedxaueb2017;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.microsoft.azure.mobile.MobileCenter;
import com.microsoft.azure.mobile.analytics.Analytics;
import com.microsoft.azure.mobile.crashes.Crashes;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        MobileCenter.start(getApplication(), "fb3ef734-0989-4973-93ce-331f9e137395", Analytics.class, Crashes.class);

    }
}

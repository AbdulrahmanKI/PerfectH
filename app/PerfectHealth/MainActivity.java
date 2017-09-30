package com.abdulrahman.asus.PerfectHealth;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity {
    private InterstitialAd caloriesAd ,vitaminAd , infoAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3834466240178402/1535133400");
       AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        caloriesAd = new InterstitialAd(this);
        caloriesAd.setAdUnitId("ca-app-pub-3834466240178402/3888945954");
        AdRequest request = new AdRequest.Builder()
                .build();
        caloriesAd.loadAd(request);

        vitaminAd = new InterstitialAd(this);
        vitaminAd.setAdUnitId("ca-app-pub-3834466240178402/7608198106");
        AdRequest requestV = new AdRequest.Builder()
                .build();
        vitaminAd.loadAd(requestV);

        infoAd = new InterstitialAd(this);
        infoAd.setAdUnitId("ca-app-pub-3834466240178402/2324915983");
        AdRequest requestI = new AdRequest.Builder()
                .build();
        infoAd.loadAd(requestI);




    }

    public void calories(View view) {
        if(caloriesAd.isLoaded())
            caloriesAd.show();
        Intent intent = new Intent(MainActivity.this,Calories.class);
        startActivity(intent);
    }

    public void vitamin(View view) {
        if(vitaminAd.isLoaded())
            vitaminAd.show();
        Intent intent = new Intent(this,Vitamin.class);
        startActivity(intent);
    }

    public void sport(View view) {
        Intent intent = new Intent(this,sport.class);
        startActivity(intent);
    }

    public void BMI(View view) {

        Intent intent = new Intent(this,BMI.class);
        startActivity(intent);
    }

    public void Information(View view) {
        if(infoAd.isLoaded())
            infoAd.show();
        Intent intent = new Intent(this,Information.class);
        startActivity(intent);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

}


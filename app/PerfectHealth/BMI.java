package com.abdulrahman.asus.PerfectHealth;

import android.content.Context;
import android.content.Intent;

import android.os.Bundle;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


public class BMI extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private InterstitialAd bmiAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        TextView te = (TextView)findViewById(R.id.editText2);
        te.setImeOptions(EditorInfo.IME_ACTION_DONE);

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        bmiAd = new InterstitialAd(this);
        bmiAd.setAdUnitId("ca-app-pub-3834466240178402/3019050559");
        AdRequest request = new AdRequest.Builder()
                .build();
        bmiAd.loadAd(request);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_calories) {
            Intent intentCalories = new Intent(this,Calories.class);
            startActivity(intentCalories);
            finish();
        } else if (id == R.id.nav_vitamin) {
            Intent intentVitamin = new Intent(this,Vitamin.class);
            startActivity(intentVitamin);
            finish();
        } else if (id == R.id.nav_sport) {
            Intent intentSport = new Intent(this,sport.class);
            startActivity(intentSport);
            finish();
        } else if (id == R.id.nav_bmi) {
            closeContextMenu();
        } else if (id == R.id.nav_info) {
            Intent intentInfo = new Intent(this,Information.class);
            startActivity(intentInfo);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void calculateBmi(View view)throws Exception {
        try {
            double hei , wei , bmi =0;
        String bmiS ;

        EditText height = (EditText)findViewById(R.id.editText);
        EditText weight = (EditText)findViewById(R.id.editText2);
        TextView result = (TextView)findViewById(R.id.resultBMI);

        hei = Double.parseDouble(height.getText().toString());
        wei = Double.parseDouble(weight.getText().toString());

        hei /=100;

        bmi = (wei/(hei*hei));
        bmiS = String.valueOf(String.format("%.1f",bmi));

        if(bmiAd.isLoaded()&& bmi!=0)
                bmiAd.show();

        result.setText(convertToEnglishDigits(bmiS));



        View view1 = this.getCurrentFocus();
        if (view1 != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        }
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "أدخل جميع الفراغات", Toast.LENGTH_SHORT).show();
        }

    }
    public static String convertToEnglishDigits(String value)
    {
        String newValue = value.replace("١", "1").replace("٢", "2").replace("٣", "3").replace("٤", "4").replace("٥", "5")
                .replace("٦", "6").replace("٧", "7").replace("٨", "8").replace("٩", "9").replace("٠", "0")
                .replace("۱", "1").replace("۲", "2").replace("۳", "3").replace("۴", "4").replace("۵", "5")
                .replace("۶", "6").replace("۷", "7").replace("۸", "8").replace("۹", "9").replace("۰", "0");

        return newValue;
    }
}

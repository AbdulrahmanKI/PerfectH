package com.abdulrahman.asus.PerfectHealth.Calories_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.abdulrahman.asus.PerfectHealth.R;

public class fruits extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruits);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}

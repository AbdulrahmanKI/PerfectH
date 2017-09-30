package com.abdulrahman.asus.PerfectHealth;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.abdulrahman.asus.PerfectHealth.Sport_menu.abs;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.arm;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.back;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.chest;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.leg;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.neck;
import com.abdulrahman.asus.PerfectHealth.Sport_menu.shoulder;

public class sport extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sport);
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
            closeContextMenu();
        } else if (id == R.id.nav_bmi) {
            Intent intentBmi = new Intent(this,BMI.class);
            startActivity(intentBmi);
            finish();
        } else if (id == R.id.nav_info) {
            Intent intentInfo = new Intent(this,Information.class);
            startActivity(intentInfo);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void neck_b(View view) {
        Intent intent = new Intent(this,neck.class);
        startActivity(intent);
    }

    public void back_b(View view) {
        Intent intent = new Intent(this,back.class);
        startActivity(intent);
    }

    public void chest_b(View view)  {
        Intent intent = new Intent(this,chest.class);
        startActivity(intent);
    }

    public void abs_b(View view) {
        Intent intent = new Intent(this,abs.class);
        startActivity(intent);
    }

    public void shoulder_b(View view) {
        Intent intent = new Intent(this,shoulder.class);
        startActivity(intent);
    }

    public void arm_b(View view) {
        Intent intent = new Intent(this,arm.class);
        startActivity(intent);
    }

    public void leg_b(View view) {
        Intent intent = new Intent(this,leg.class);
        startActivity(intent);
    }
}

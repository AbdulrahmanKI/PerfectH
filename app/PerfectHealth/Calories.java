package com.abdulrahman.asus.PerfectHealth;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.abdulrahman.asus.PerfectHealth.Calories_menu.buttonCaluclate;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.chicken;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.drinks;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.fish;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.fruits;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.grain;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.meat;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.milk;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.nuts;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.oil;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.spices;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.sweet;
import com.abdulrahman.asus.PerfectHealth.Calories_menu.vegetable;
import com.abdulrahman.asus.PerfectHealth.widgets.FontOverride;


import java.util.ArrayList;


public class Calories extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    static boolean flag = true;
    ObjectAnimator anim,anim2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);
        if(flag==true) {
            Button bt = (Button) findViewById(R.id.calculator);
            anim = ObjectAnimator.ofFloat(bt, "scaleX", 0.9f);
            anim.setDuration(200); // duration 3 seconds
            anim.start();

            // Make the object height 50%
            anim2 = ObjectAnimator.ofFloat(bt, "scaleY", 0.9f);
            anim2.setDuration(200); // duration 3 seconds
            anim2.start();

            anim.setRepeatCount(100);
            anim.setRepeatMode(ValueAnimator.REVERSE);

            anim2.setRepeatCount(100);
            anim2.setRepeatMode(ValueAnimator.REVERSE);
        }


        FontOverride.setDefaultFont(this, "MONOSPACE", "fonts/DroidKufi-Regular.ttf");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ArrayList<prodcuts> myList = new ArrayList<>();
        myList.add(new prodcuts("حليب و مشتقاته",R.drawable.milk));
        myList.add(new prodcuts("المشروبات و العصائر",R.drawable.drinks));
        myList.add(new prodcuts("الزيوت و الدهون",R.drawable.olive_oil));
        myList.add(new prodcuts("الفواكه",R.drawable.fruits));
        myList.add(new prodcuts("الخضار",R.drawable.vegetables));
        myList.add(new prodcuts("اللحوم الحمراء",R.drawable.meat));
        myList.add(new prodcuts("الدواجن",R.drawable.chicken));
        myList.add(new prodcuts("البقوليات و الحبوب",R.drawable.grain));
        myList.add(new prodcuts("الأسماك",R.drawable.fish));
        myList.add(new prodcuts("البهارات و التوابل",R.drawable.spices));
        myList.add(new prodcuts("المكسرات",R.drawable.nuts));
        myList.add(new prodcuts("الحلويات",R.drawable.sweet));

        ListReouces listres = new ListReouces(myList);
        ListView ls = (ListView)findViewById(R.id.listView);
        ls.setAdapter(listres);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent intent = new Intent(view.getContext(), milk.class);
                        startActivity(intent);
                    break;
                    case 1:
                        Intent intent1 = new Intent(view.getContext(),drinks.class);
                        startActivity(intent1);
                    break;
                    case 2:
                        Intent intent2 = new Intent(view.getContext(),oil.class);
                        startActivity(intent2);
                    break;
                    case 3:
                        Intent intent3 = new Intent(view.getContext(),fruits.class);
                        startActivity(intent3);
                     break;
                    case 4:
                        Intent intent4 = new Intent(view.getContext(),vegetable.class);
                        startActivity(intent4);
                     break;
                    case 5:
                        Intent intent5 = new Intent(view.getContext(),meat.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(view.getContext(),chicken.class);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(view.getContext(),grain.class);
                        startActivity(intent7);
                        break;
                    case 8:
                        Intent intent8 = new Intent(view.getContext(),fish.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(view.getContext(),spices.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(view.getContext(),nuts.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(view.getContext(),sweet.class);
                        startActivity(intent11);
                        break;

                }
            }
        });


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
            closeContextMenu();
        } else if (id == R.id.nav_vitamin) {
            Intent intentVitamin = new Intent(this,Vitamin.class);
            startActivity(intentVitamin);
            finish();
        } else if (id == R.id.nav_sport) {
            Intent intentSport = new Intent(this,sport.class);
            startActivity(intentSport);
            finish();
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

    public void ButtonCal(View view) {
        if(flag) {
            anim.cancel();
            anim2.cancel();
            flag = false;
        }
        Intent intent = new Intent(this,buttonCaluclate.class);
        startActivity(intent);
    }

    private class ListReouces extends BaseAdapter{

        ArrayList<prodcuts> myList = new ArrayList<>();

      ListReouces(ArrayList<prodcuts> myList){this.myList=myList;
      }



        @Override
        public int getCount() {
            return myList.size();
        }

        @Override
        public Object getItem(int position) {
            return myList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = getLayoutInflater();
            View row = inflater.inflate(R.layout.listrow,parent,false);
            TextView title = (TextView)row.findViewById(R.id.titleRow);
            ImageView image = (ImageView)row.findViewById(R.id.imageRow);

            prodcuts temp = myList.get(position);

            title.setText(temp.name);
            image.setImageResource(temp.img);
            return row;
        }
    }



}

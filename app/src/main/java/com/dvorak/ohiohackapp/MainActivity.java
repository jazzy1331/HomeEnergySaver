package com.dvorak.ohiohackapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, AdapterView.OnItemSelectedListener {

    private String SP_NAME = "cbushackpref";
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Create Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.rooms_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        sp = getSharedPreferences(SP_NAME, Context.MODE_APPEND);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case 0:
            case 1:
            case 2:
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String room = "";

        switch (i) {
            case 0:
                room = "LR";
            case 1:
                room = "K";
            case 2:
                room = "DR";
            case 3:
                room = "BM";
            case 4:
                room = "B1";
            case 5:
                room = "B2";
            case 6:
                room = "B3";
            case 7:
                room = "B4";
        }

        changeState(room);


    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void changeState(String roomId) {

        Calendar c = Calendar.getInstance();
        int hour = c.HOUR_OF_DAY;
        int min = c.MINUTE;

        int seconds = (hour * 3600) + (min * 60);

        int elapsedTimeSecs = 0;

        SharedPreferences.Editor editor = sp.edit();
        String currentState = sp.getString(roomId, "F");

        if(currentState.equals("F")){
            editor.putString(roomId + "start", Integer.toString(seconds));
            editor.putString(roomId, "T");
        }else{
            elapsedTimeSecs = seconds - Integer.parseInt(sp.getString(roomId + "start", "0"));
            editor.putString(roomId, "F");
        }

        double elapsedTimeHours = elapsedTimeSecs / 3600;

        double kwhUsage = 0;

        if(roomId.equals("LR")){
            kwhUsage = elapsedTimeHours * .44;
        }else if(roomId.equals("K")){
            kwhUsage = elapsedTimeHours * .7836;
        }else if(roomId.equals("DR")){
            kwhUsage = elapsedTimeHours * .24;
        }else if(roomId.contains("B")){
            kwhUsage = elapsedTimeHours *.44;
        }



    }
}

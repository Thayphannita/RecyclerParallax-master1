package com.arjunalabs.android.recyclerparallax;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Paralax
    ParallaxRecyclerView recyclerView;
    ArrayList<ParallaxModel> parallaxModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //set title
        this.setTitle("Categories");
        //Toolbar
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         //Drawer Layout
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view) ;
        navigationView.setNavigationItemSelectedListener(this);



        // create dummy data
        parallaxModelArrayList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            ParallaxModel parallaxModel = new ParallaxModel();
            parallaxModel.setTitle("Row" + i);
            parallaxModelArrayList.add(parallaxModel);
        }

        // prepare the recycler view
        recyclerView = (ParallaxRecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
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
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        // do the adapter
        ParallaxAdapter parallaxAdapter = new ParallaxAdapter(parallaxModelArrayList, recyclerView.getHeight());
        // bind the adapter with the recyclerview
        recyclerView.setAdapter(parallaxAdapter);

        recyclerView.setupParallax(this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main_menu, menu);
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

    //Implement from navigation
     @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        //Handle navigation view items click here
         int id = item.getItemId();

         if(id == R.id.tour_promotion){
             //Handle the camera action
         }else if (id == R.id.favourite){

         }else if(id == R.id.nav_share){

         }else if(id ==  R.id.nav_send){

         }

         DrawerLayout drawerLayout =(DrawerLayout)findViewById(R.id.drawer_layout);
         drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}

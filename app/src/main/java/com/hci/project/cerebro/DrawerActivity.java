package com.hci.project.cerebro;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, LearnerFragment.LearnerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        // Start - Defaulting the application with Learner fragment -
        LearnerFragment fragment1 = new LearnerFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frag_frame, fragment1);
        fragmentTransaction.commit();
        hideLearnerItem();
        // End

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Set user name and email in hamburger menu
        SharedPreferences settings = getApplicationContext().getSharedPreferences("MyPref",0);
        String fname = settings.getString("Current_User_fName", "defaultvalue");
        String lname = settings.getString("Current_User_lName", "defaultvalue");
        String email = settings.getString("Current_User_email", "defaultvalue");
        String username = fname + " " + lname;
        TextView txtProfileName = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tab_username);
        TextView txtProfileEmail = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tab_email);
        txtProfileName.setText(username);
        txtProfileEmail.setText(email);
        //End

    }
    NavigationView navigationView;

    private void hideLearnerItem() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_learner).setVisible(false);
        nav_Menu.findItem(R.id.nav_tutor).setVisible(true);
    }
    private void hideTutorItem() {
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.nav_learner).setVisible(true);
        nav_Menu.findItem(R.id.nav_tutor).setVisible(false);
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

    public void onLoad() {
        Button submitQuestion = (Button) findViewById(R.id.submit_question);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
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
//    LearnerFragment fragment1 = new LearnerFragment();
//    TutorFragment fragment2 = new TutorFragment();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        Log.i("NavSelected :", "Inside");
        int id = item.getItemId();
        LearnerFragment fragment1 = new LearnerFragment();
        TutorFragment fragment2 = new TutorFragment();
        if (id == R.id.nav_learner) {
            // Handle the camera action
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frag_frame, fragment1);
            hideLearnerItem();
            fragmentTransaction.commit();

        } else if (id == R.id.nav_tutor) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frag_frame, fragment2);
            hideTutorItem();
            fragmentTransaction.commit();

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {
                SharedPreferences myPrefs = getApplicationContext().getSharedPreferences("MyPref",0);
                SharedPreferences.Editor editor = myPrefs.edit();
                editor.clear();
                editor.commit();
                //AppState.getSingleInstance().setLoggingOut(true);
                setLoginState(true);
                Log.d("Logout ?? ", "Now log out and start the activity login");
                Intent intent = new Intent(DrawerActivity.this,
                        LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);
    }
    private void setLoginState(boolean status) {
        SharedPreferences sp = getSharedPreferences("LoginState",
                MODE_PRIVATE);
        SharedPreferences.Editor ed = sp.edit();
        ed.putBoolean("setLoggingOut", status);
        ed.commit();
    }
}

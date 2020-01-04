package com.example.betano;

import android.content.Intent;
import android.os.Bundle;

import com.example.betano.models.FootballLeague;
import com.example.betano.models.FootballTeam;
import com.example.betano.models.Gambler;
import com.example.betano.views.FragmentAbout;
import com.example.betano.views.FragmentAllBets;
import com.example.betano.views.FragmentHome;
import com.example.betano.views.FragmentMyBets;
import com.example.betano.views.FragmentProfile;
import com.example.betano.views.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    FragmentHome fragmentHome = new FragmentHome();
    FirebaseAuth auth = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        fragmentTransaction.replace(R.id.content_frame, fragmentHome);
        fragmentTransaction.commit();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Home");
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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

        ActionBar actionBar = getSupportActionBar();
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_home:
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                FragmentHome fragmentHome = new FragmentHome();
                fragmentTransaction.replace(R.id.content_frame,fragmentHome);
                fragmentTransaction.addToBackStack("home");
                fragmentTransaction.commit();
                break;

            case R.id.nav_profile:
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                FragmentProfile fragmentProfile = new FragmentProfile();
                fragmentTransaction1.replace(R.id.content_frame,fragmentProfile);
                fragmentTransaction1.addToBackStack("profile");
                fragmentTransaction1.commit();
                break;

            case R.id.nav_all_bets:
                FragmentManager fragmentManager2 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction2 = fragmentManager2.beginTransaction();
                FragmentAllBets fragmentAllBets = new FragmentAllBets();
                fragmentTransaction2.replace(R.id.content_frame,fragmentAllBets);
                fragmentTransaction2.addToBackStack("all_bets");
                fragmentTransaction2.commit();
                break;

            case R.id.nav_my_bets:
                FragmentManager fragmentManager3 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction3 = fragmentManager3.beginTransaction();
                FragmentMyBets fragmentMyBets = new FragmentMyBets();
                fragmentTransaction3.replace(R.id.content_frame,fragmentMyBets);
                fragmentTransaction3.addToBackStack("profile");
                fragmentTransaction3.commit();
                break;

            case R.id.nav_about:
                FragmentManager fragmentManager4 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction4 = fragmentManager4.beginTransaction();
                FragmentAbout fragmentAbout = new FragmentAbout();
                fragmentTransaction4.replace(R.id.content_frame,fragmentAbout);
                fragmentTransaction4.addToBackStack("profile");
                fragmentTransaction4.commit();
                break;

            case R.id.nav_log_out:
                auth.signOut();
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                finish();
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

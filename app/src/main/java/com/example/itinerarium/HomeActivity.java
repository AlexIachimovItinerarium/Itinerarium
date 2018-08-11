package com.example.itinerarium;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView homeBottomNav = findViewById(R.id.home_bottom_navigation);
        homeBottomNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener  = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Activity selectedActivity = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    //Intent
                    break;
                case R.id.nav_notification:
                    //Intent
                    break;
                case R.id.nav_search:
                    //Intent
                    break;
                case R.id.nav_favorites:
                    //Intent
                    break;
                case R.id.nav_menu:
                    //Intent
                    break;
            }
            return true;
        }
    };
}
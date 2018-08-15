package com.example.itinerarium.activities;

import com.example.itinerarium.R;
import com.example.itinerarium.utils.ScreenNavigation;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class HomeActivity extends AppCompatActivity {

  private Fragment mapFragment;
  private Fragment activeFragment;
  private ScreenNavigation screenNavigation;

  private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

      switch (item.getItemId()) {
        case R.id.nav_map:
          screenNavigation.replaceFragment(activeFragment, mapFragment);
          activeFragment = mapFragment;
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

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);
    screenNavigation = new ScreenNavigation(this);

    BottomNavigationView homeBottomNav = findViewById(R.id.home_bottom_navigation);
    homeBottomNav.setOnNavigationItemSelectedListener(navListener);

    mapFragment = com.example.itinerarium.fragments.MapFragment.newInstance();
    activeFragment = mapFragment;
    screenNavigation.addFragment(R.id.main_container, mapFragment);
  }
}
package com.example.itinerarium.activities;

import com.example.itinerarium.R;
import com.example.itinerarium.utils.ScreenNavigation;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

  private ScreenNavigation screenNavigation;
  private Context activityContext;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    activityContext = this;
    screenNavigation = new ScreenNavigation(this);

    Thread thread = new Thread(){
      @Override
      public void run() {
        try {
          sleep(3 * 1000);
          screenNavigation.switchActivity(activityContext, LogInActivity.class);
        } catch (Exception e) {
        }
      }
    };
    thread.start();
  }
}

package com.example.itinerarium.activities;

import com.example.itinerarium.R;
import com.example.itinerarium.utils.ScreenNavigation;
import com.example.itinerarium.utils.AnimationManager;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;




public class SplashActivity extends AppCompatActivity {

  private ScreenNavigation screenNavigation;
  private AnimationManager animationManager;
  private Context activityContext;
  private TextView appNameTextView;



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);
    activityContext = this;
    screenNavigation = new ScreenNavigation(this);
    appNameTextView = findViewById(R.id.appNameTextView);

    Thread thread = new Thread(){
      @Override
      public void run() {
        try {
          animationManager.setAlphaAnimationToView(3000, appNameTextView);
          sleep(3 * 1000);
          screenNavigation.switchActivity(activityContext, LogInActivity.class);
        } catch (Exception e) {
        }
      }
    };
    thread.start();
  }
}

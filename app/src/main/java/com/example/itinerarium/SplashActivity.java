package com.example.itinerarium;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(2*1000);
                    Intent loginIntent = new Intent(getApplicationContext(), LogInActivity.class);
                    startActivity(loginIntent);
                }catch (Exception e){
                }
            }
        };
        thread.start();
    }
}

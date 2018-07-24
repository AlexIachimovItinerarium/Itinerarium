package com.example.itinerarium;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Thread thread = new Thread(){
            @Override
            public void run(){
                try{
                    sleep(5*1000);
                    Intent loginIntent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(loginIntent);
                }
                catch (Exception e){
                }
            }
        };
        thread.start();
    }
}

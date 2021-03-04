package com.example.quanlythuchi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class LaunchingScreen extends AppCompatActivity {
    Thread thread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launching_screen);
        thread = new Thread(){
          @Override
          public void run(){
              super.run();
              int waited =0;
              while(waited <2000){
                  try {
                      sleep(100);
                  }catch (InterruptedException e){
                      e.printStackTrace();
                  }
                  waited+=100;
              }
              Intent intent = new Intent(LaunchingScreen.this, MainActivity.class);
              intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
              startActivity(intent);
              finish();
          }
        };
        thread.start();
    }
}

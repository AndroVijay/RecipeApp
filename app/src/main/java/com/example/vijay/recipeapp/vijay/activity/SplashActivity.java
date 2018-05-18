package com.example.vijay.recipeapp.vijay.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.vijay.recipeapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends AppCompatActivity {

    private Timer timer;
    private ProgressBar progressBar;
    private int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBar=findViewById(R.id.progressBar);
        progressBar.setProgress(0);
       //textView=findViewById(R.id.textView);
        //textView.setText(" ");

        final long period=100;
        timer=new Timer();
        timer.schedule(new TimerTask() {

            @Override
            public void run() {

                if (i<100)
                {
//                    runOnUiThread(new Runnable() {
//
//                        @Override
//                        public void run() {
//                            textView.setText(String.valueOf(i)+"%");
//                        }
//                    });
                    progressBar.setProgress(i);
                    i++;
                }else {

                    timer.cancel();
                    Intent intent=new Intent(SplashActivity.this,FoodListActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },0,period);
    }
}

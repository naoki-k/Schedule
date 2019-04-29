package com.example.workspace.schedule.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.example.workspace.schedule.R;
import com.example.workspace.schedule.presentation.home.HomeActivity;

public class SplashActivity extends AppCompatActivity {

    final Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mHandler.postDelayed(mSplashTask, 2000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mHandler.removeCallbacks(mSplashTask);
    }

    private Runnable mSplashTask = new Runnable() {
        @Override
        public void run() {
            Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
            startActivity(intent);
            finish();
        }
    };
}

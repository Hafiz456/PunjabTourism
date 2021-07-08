package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar = findViewById(R.id.progressBar);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnim();
    }
//    public void progressAnim(){
//        ProgressBarAnime progressBarAnime = new ProgressBarAnime(this, progressBar, textView, 0f, 100f);
//        progressBarAnime.setDuration(5000);
//        progressBar.setAnimation(progressBarAnime);
//    }
private void progressAnim(){
    ProgressBar mProgressBar = (ProgressBar) findViewById(R.id.progressBar);
    ObjectAnimator progressAnimator = ObjectAnimator.ofInt(mProgressBar, "progress", 0, 100);
    progressAnimator.setDuration(5000);
    progressAnimator.setInterpolator(new LinearInterpolator());
    progressAnimator.start();
    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            start();
        }
    }, 5000);



}
    public void start(){
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
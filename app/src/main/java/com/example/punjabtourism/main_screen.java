package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.content.Intent.ACTION_DIAL;

public class main_screen extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        button = findViewById(R.id.book);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri number = Uri.parse("tel:123456789");
                Intent intent = new Intent(ACTION_DIAL,number );
                startActivity(intent);

            }
        });
    }

    public void logout(View view) {
        SharedPreferences prefs;
        prefs=getSharedPreferences("abc",MODE_PRIVATE);
        prefs.edit().clear().commit();
        Intent logout = new Intent(this, Login.class);
        startActivity(logout);
    }

    public void upcomings(View view){
        Intent intent = new Intent(this, UpcomingTrips.class);
        startActivity(intent);
    }

    public void touristsPoints(View view){
        Intent intent = new Intent(this, TouristsPoints.class);
        startActivity(intent);
    }

    public void makePlan(View view){
        Intent intent = new Intent(this, MakePlan.class);
        startActivity(intent);
    }

    public void gallery(View view){
        Intent intent = new Intent(this, Gallery.class);
        startActivity(intent);
    }
}
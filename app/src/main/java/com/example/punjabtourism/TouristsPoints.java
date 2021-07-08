package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class TouristsPoints extends AppCompatActivity {
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tourists_points);

        intent = new Intent(this, PointsDetails.class);
    }

    public void lahore(View view){
        intent.putExtra("point", "lahore");
        startActivity(intent);
    }

    public void bahawalpur(View view){
        intent.putExtra("point", "bahawalpur");
        startActivity(intent);
    }

    public void multan(View view){
        intent.putExtra("point", "multan");
        startActivity(intent);
    }

    public void sialkot(View view){
        intent.putExtra("point", "sialkot");
        startActivity(intent);
    }

    public void islamabad(View view){
        intent.putExtra("point", "islamabad");
        startActivity(intent);
    }

    public void faisalabad(View view){
        intent.putExtra("point", "faisalabad");
        startActivity(intent);
    }

    public void taxila(View view){
        intent.putExtra("point", "taxila");
        startActivity(intent);
    }

    public void kasur(View view){
        intent.putExtra("point", "kasur");
        startActivity(intent);
    }
}
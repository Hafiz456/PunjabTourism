package com.example.punjabtourism;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MakePlan extends AppCompatActivity {

    EditText amount;
    TextView tourDetails;
    int num;
    String textTour = "In this amount you can have these following given tours: ", txtTour = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_plan);

        amount = findViewById(R.id.txtAmount);
        tourDetails = findViewById(R.id.tourText);
    }

    public void findTour(View view){
        num = Integer.valueOf(amount.getText().toString());

        if(num >= 3000 && num <= 5000){
            txtTour = textTour + "\n\n 1.One Day Tour to kasur  \n 2. One Day Tour to Sialkot ";
        } else if(num > 5000 && num <= 8000) {
            txtTour = textTour + "\n\n 1. One Day Tour to Faisalabad \n 2. One Day Tour to Khairpur \n 3. 2 Days Tour to Lahore";
        } else if(num > 8000 && num <= 12000) {
            txtTour = textTour + "\n\n 1. 2 Days Tour to Taxila \n 2. 1 Days Tour to Fasialabad \n 3. 2 Days Tour to Multan";
        } else if(num > 12000 && num <= 15000) {
            txtTour = textTour + "\n\n 1. 3 Days Tour to Lahore \n 2. 3 Days Tour to Islamabad \n 3. 4 Days Tour to Bahawalpur";
        } else if(num > 15000 && num <= 20000) {
            txtTour = textTour + "\n\n 1. 5 Days Tour to Lahore \n 2. 4 Days Tour to Islamabad \n 3. 4 Days Tour to Taxila,Kasur, Sialkot each";
        } else {  txtTour = "You have entered wrong amount. Kindly input between 3,000 and 20,000";  }

        tourDetails.setText(txtTour);
    }

}
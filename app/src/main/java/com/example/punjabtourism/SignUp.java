package com.example.punjabtourism;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SignUp extends AppCompatActivity {
    TextView Name, Email, Password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
    }

    public void OnSignUp(View v) {
        Name = findViewById(R.id.signUpName);
        Email = findViewById(R.id.signUpEmail);
        Password = findViewById(R.id.signUpPassword);
        String name, email, password;
        name = Name.getText().toString();
        email = Email.getText().toString();
        password = Password.getText().toString();

        SQLiteDatabase db = openOrCreateDatabase("Database", MODE_PRIVATE, null);
        String CraeteTableQuery = " CREATE TABLE IF NOT EXISTS "
                + "SignUp "
                + " (Name VARCHAR , Email VARCHAR , Password VARCHAR );";
        String InsertQuery = " INSERT INTO SignUp VALUES ('" + name + "','" + email + "','" + password + "')";
        String SelectQuery = "SELECT * FROM SignUp WHERE Email ='" + email + "'";

        if (name.equals("") || email.equals("") || password.equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
            builder.setTitle("SignUp Alert")
                    .setMessage("Plaese Fill all fields For SignUp")
                    .setCancelable(false)
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            String Emailreges = "^(.+)@(.+)$";
            Pattern Emailpattern = Pattern.compile(Emailreges);
            Matcher Emailmatcher = Emailpattern.matcher(email);


            if (Emailmatcher.matches() && password.length() >= 7) {

                try {
                    db.execSQL(CraeteTableQuery);

                    Cursor resultSet = db.rawQuery(SelectQuery, null);

                    if (resultSet.moveToFirst()) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                        builder.setTitle("SignUp Alert")
                                .setMessage("Please Enter another Email Because This is already used")
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.cancel();
                                    }
                                });
                        AlertDialog dialog = builder.create();
                        dialog.show();
                    }
                    else {
                        db.execSQL(InsertQuery);
                        Intent intent = new Intent(this, Login.class);
                        startActivity(intent);
                        finish();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            else {
                if (Emailmatcher.matches() != true) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                    builder.setTitle("SignUp Alert")
                            .setMessage("Please Enter Valid Email Adress LIKE abc@gmail.com")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
                if (password.length() <= 6) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(SignUp.this);
                    builder.setTitle("SignUp Alert")
                            .setMessage("Please Enter Valid Password with min 8 characters")
                            .setCancelable(false)
                            .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        }
    }

    public void OnLoginScreen(View v) {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
        finish();
    }
}
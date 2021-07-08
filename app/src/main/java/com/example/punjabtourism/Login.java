package com.example.punjabtourism;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {
    EditText Email_1, Password_1;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        prefs=getSharedPreferences("abc",MODE_PRIVATE);
        String username = prefs.getString("Name",null);
        if (username != null)
        {
            Toast.makeText(this,"Already loggedIn,Redirecting to Home_screen ",Toast.LENGTH_LONG);
            Intent intent=new Intent(this,home_screen.class);
            startActivity(intent);
        }
    }

    public void onsignupscreen(View view) {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
        finish();
    }

    public void onlogin(View view) {
        Email_1 = findViewById(R.id.accepterLocation);
        Password_1 = findViewById(R.id.loginPassword);

        if (Email_1.getText().toString().equals("") || Password_1.getText().toString().equals("")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
            builder.setTitle("Login Alert")
                    .setMessage("Please Enter Email and Password For Login")
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
            try {
                SQLiteDatabase db = openOrCreateDatabase("Database", Context.MODE_PRIVATE, null);
                String SelectQuery = "SELECT * FROM SignUp WHERE Email ='" + Email_1.getText().toString() + "' AND Password='" + Password_1.getText().toString() + "'";

                Cursor resultSet = db.rawQuery(SelectQuery, null);
                if (resultSet.moveToFirst()) {

                    prefs = getSharedPreferences("abc", MODE_PRIVATE);
                    SharedPreferences.Editor prefsEditor = prefs.edit();
                    prefsEditor.putString("Name", resultSet.getString(0));
                    prefsEditor.commit();

                    SharedPreferences prefs2 = getSharedPreferences("ab", MODE_PRIVATE);
                    SharedPreferences.Editor prefs2Editor = prefs.edit();
                    prefsEditor.putString("Email", resultSet.getString(1));
                    prefsEditor.commit();


                    Intent intent = new Intent(this, home_screen.class);
                    startActivity(intent);
                    finish();
                } else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
                    builder.setTitle("Login Alert")
                            .setMessage("Plaese Enter Correct Email and Password For Login")
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

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
package com.jubair.nsu.cse486.sec1.foodies;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landingpage);
    }

    public void OpenChef(View v) {
        startActivity(new Intent(MainActivity.this, Chef_login.class));
    }

    public void OpenCustomer(View v) {
        startActivity(new Intent(MainActivity.this, Customer_login.class));
    }






}
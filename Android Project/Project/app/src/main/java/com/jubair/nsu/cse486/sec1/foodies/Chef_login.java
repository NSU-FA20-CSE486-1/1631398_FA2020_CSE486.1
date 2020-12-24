package com.jubair.nsu.cse486.sec1.foodies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Chef_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login);
    }



    public void OpenChefRegistration(View v) {
        startActivity(new Intent(this, Chef_Registration.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

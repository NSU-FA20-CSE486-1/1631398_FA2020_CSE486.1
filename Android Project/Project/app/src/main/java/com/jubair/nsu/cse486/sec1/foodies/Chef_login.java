package com.jubair.nsu.cse486.sec1.foodies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;

public class Chef_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_login);
    }



    public void OpenChefRegistration(View v) {
        startActivity(new Intent(this, Chef_Registration.class));
    }

    public void login(View v) {
        startActivity(new Intent(this, Chef_Homepage.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

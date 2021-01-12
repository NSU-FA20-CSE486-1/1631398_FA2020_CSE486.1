package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.appcompat.app.AppCompatActivity;
import com.jubair.nsu.cse486.sec1.foodies.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Chef_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_profile);
    }

    public void updateProfile(View v) {
        startActivity(new Intent(this, Chef_AddItem.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Homepage.class));
    }
}
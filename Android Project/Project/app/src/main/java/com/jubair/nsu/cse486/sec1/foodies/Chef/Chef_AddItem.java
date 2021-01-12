package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jubair.nsu.cse486.sec1.foodies.R;

public class Chef_AddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_add_item);
    }

    public void addConfirm(View v) {
     //   startActivity(new Intent(Chef_Kitchen.this, Chef_AddItem.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Kitchen.class));
    }
}
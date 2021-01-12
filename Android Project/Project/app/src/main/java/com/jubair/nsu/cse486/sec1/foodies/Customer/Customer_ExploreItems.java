package com.jubair.nsu.cse486.sec1.foodies.Customer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jubair.nsu.cse486.sec1.foodies.R;

public class Customer_ExploreItems extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_explore_items);
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Homepage.class));
    }


}

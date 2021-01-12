package com.jubair.nsu.cse486.sec1.foodies.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_AddItem;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Kitchen;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class Customer_Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_hompage);
    }

    public void exploreItems(View v) {
        startActivity(new Intent(this, Customer_ExploreItems.class));
    }

    public void event(View v) {
        startActivity(new Intent(this, Customer_Event.class));
    }

    public void monthlyPlan(View v) {
        startActivity(new Intent(this, Customer_MonthlyPlan.class));
    }

    public void profile_customer(View v) {
        startActivity(new Intent(this, Customer_Profile.class));
    }







}
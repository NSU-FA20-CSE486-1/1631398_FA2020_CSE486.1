package com.jubair.nsu.cse486.sec1.foodies.Orders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Items;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Profile;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class ConfirmOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
    }

    public void GoHome(View view){
        startActivity(new Intent(this, Customer_Homepage.class));
    }

    public void profile(View view){
        startActivity(new Intent(this, Customer_Profile.class));
    }
}
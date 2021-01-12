package com.jubair.nsu.cse486.sec1.foodies;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;

public class Customer_login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
    }


    public void OpenCustomerRegistration(View v) {
        startActivity(new Intent(this, Customer_Registration.class));
    }

    public void loginCustomer(View v) {
        startActivity(new Intent(this, Customer_Homepage.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, MainActivity.class));
    }
}

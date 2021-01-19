package com.jubair.nsu.cse486.sec1.foodies.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_AddItem;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Kitchen;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class Customer_Items extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_items);
    }

    public void ViewItem(View v) {
        startActivity(new Intent(Customer_Items.this, Customer_ShowItem.class));
    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Homepage.class));
    }
}
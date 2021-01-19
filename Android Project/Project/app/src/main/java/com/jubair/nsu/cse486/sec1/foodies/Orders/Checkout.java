package com.jubair.nsu.cse486.sec1.foodies.Orders;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Event;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Items;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class Checkout extends AppCompatActivity {
    TextView setType;
    TextView set_Price;
    TextView showQuantity;
    TextView showDate;
    TextView showTotal;
    TextView showPay;
 //   String price;
    int price;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        setType = findViewById(R.id.eventType);
        set_Price = findViewById(R.id.setPrice);
        showQuantity = findViewById(R.id.quantityText);
        showDate = findViewById(R.id.dateText);
        showTotal = findViewById(R.id.totalText);
        showPay = findViewById(R.id.payText);

        Intent intent = getIntent();

        String set = intent.getStringExtra(Customer_Event.EXTRA_SET);
        String date = intent.getStringExtra(Customer_Event.EXTRA_DATE);
        String quantity = intent.getStringExtra(Customer_Event.EXTRA_QUANTITY);


        //Price for each set  ------- NOT WORKING
        if(set == "Set A"){
            price = 180;
        }
        if(set == "Set B"){
            price = 150;
        }
        if(set == "Set C"){
            price = 160;
        }
        if(set == "Set D"){
            price = 250;
        }
        // Assuming a static price
        int p = 200;

        int Quantity = Integer.parseInt(quantity);  // Converting textview to integer

        //Calculate total amount
        int total = p*Quantity ;
        int pay = total+100;



        setType.setText(set);
        set_Price.setText(Integer.toString(p));
        showDate.setText(date);
        showQuantity.setText(quantity);
        showTotal.setText(Integer.toString(total));
        showPay.setText(Integer.toString(pay));

    }

    public void placeOrder(View view){


        startActivity(new Intent(this, ConfirmOrder.class));
    }


    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Event.class));
    }



}
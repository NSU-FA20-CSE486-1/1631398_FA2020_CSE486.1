package com.jubair.nsu.cse486.sec1.foodies.Customer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Orders.Checkout;
import com.jubair.nsu.cse486.sec1.foodies.R;

public class Customer_Event extends AppCompatActivity {
    public static final String EXTRA_DATE = "ccom.jubair.nsu.cse486.sec1.foodies.Customer.MESSAGE";
    public static final String EXTRA_QUANTITY = "com.jubair.nsu.cse486.sec1.foodies.Customer.ITEMS";
    public static final String EXTRA_SET= "com.jubair.nsu.cse486.sec1.foodies.Customer.SET";
    public static final String EXTRA_PRICE= "com.jubair.nsu.cse486.sec1.foodies.Customer.PRICE";

    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText date;
    EditText quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_event);

        radioGroup = findViewById(R.id.radioGroupEvent);
        date = findViewById(R.id.editTextDate);
        quantity=  findViewById(R.id.editTextNumber);
    }

    public void confirmEvent(View view){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        String eventCategory = radioButton.getText().toString();
        String Date = date.getText().toString();
        String Quantity = quantity.getText().toString();

        Intent i = new Intent(this, Checkout.class);

        i.putExtra(EXTRA_SET, eventCategory);
        i.putExtra(EXTRA_DATE, Date);
        i.putExtra(EXTRA_QUANTITY, Quantity);
        startActivity(i);

    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Homepage.class));
    }
}
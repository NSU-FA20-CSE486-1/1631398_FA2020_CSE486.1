package com.jubair.nsu.cse486.sec1.foodies.Orders;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_AddItem;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Event;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Items;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Checkout extends AppCompatActivity {
    TextView setType,set_Price,showQuantity,showDate,showTotal,showPay;
    EditText name,address,phone;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore db;
    ProgressDialog pd;
    int price,total,pay;
    String customerID, set,date,quantity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        mFirebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        pd = new ProgressDialog(this);

        setType = findViewById(R.id.eventType);
        set_Price = findViewById(R.id.setPrice);
        showQuantity = findViewById(R.id.quantityText);
        showDate = findViewById(R.id.dateText);
        showTotal = findViewById(R.id.totalText);
        showPay = findViewById(R.id.payText);
        name = findViewById(R.id.editTextTextPersonName7);
        address = findViewById(R.id.editTextTextPersonName);
        phone = findViewById(R.id.editTextTextPersonName4);

        Intent intent = getIntent();

         set = intent.getStringExtra(Customer_Event.EXTRA_SET);
         date = intent.getStringExtra(Customer_Event.EXTRA_DATE);
         quantity = intent.getStringExtra(Customer_Event.EXTRA_QUANTITY);


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
         total = p*Quantity ;
         pay = total+100;



        setType.setText(set);
        set_Price.setText(Integer.toString(p));
        showDate.setText(date);
        showQuantity.setText(quantity);
        showTotal.setText(Integer.toString(total));
        showPay.setText(Integer.toString(pay));

    }

    public void placeOrder(View view){

        String personName = name.getText().toString();
        String personAddress = address.getText().toString();
        String personPhone = phone.getText().toString();

        if(personName.isEmpty()){
            name.setError("Please enter name");
            name.requestFocus();
        }
        else if(personAddress.isEmpty()){
            address.setError("Please enter address");
            address.requestFocus();
        }
        else if(personPhone.isEmpty()){
            phone.setError("Please enter phone number");
            phone.requestFocus();
        }

        else if(!(personName.isEmpty() && personAddress.isEmpty() && personPhone.isEmpty())){

            //Set title of progress bar
            pd.setTitle("Placing order for your event...");
            //Show progress bar when user click confirm button
            pd.show();

            customerID = mFirebaseAuth.getCurrentUser().getEmail() ;
    //        foodID = UUID.randomUUID().toString();



            DocumentReference documentReference = db.collection("Orders").document("Event").collection(customerID).document()  ;

            Map<String,Object> item = new HashMap<>();
            item.put("Menu", set );
            item.put("Quantity", quantity );
            item.put("EventDate", date );
            item.put("TotalAmount", Integer.toString(pay) );
            item.put("CustomerName", personName);
            item.put("CustomerAddress", personAddress);
            item.put("CustomerPhone", personPhone);

            //add data
            documentReference.set(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    // this will be called when data is added successfully
                    pd.dismiss();
                    Toast.makeText(Checkout.this,"Order Placed Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Checkout.this, ConfirmOrder.class));
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // this will be called if there is error while uploading
                    Toast.makeText(Checkout.this, e.getMessage() ,Toast.LENGTH_SHORT).show();
                }
            });
        }
        else{
            Toast.makeText(Checkout.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
        }




    }


    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_Event.class));
    }



}
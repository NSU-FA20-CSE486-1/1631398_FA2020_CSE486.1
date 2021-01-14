package com.jubair.nsu.cse486.sec1.foodies.Chef;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jubair.nsu.cse486.sec1.foodies.R;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Chef_AddItem extends AppCompatActivity {

 //   RadioButton bangla,chinese,fast_food;
    EditText name,description, price ;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore db;
    ProgressDialog pd;
    String chefID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_add_item);

        //actionbar and its title
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setTitle("Add Data");

        mFirebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();
        pd = new ProgressDialog(this);

        name = findViewById(R.id.editTextTextPersonName3);
        description = findViewById(R.id.editTextTextMultiLine);
        price = findViewById(R.id.editTextTextPersonName9);
//        bangla = findViewById(R.id.radioButtonBangla);
//        chinese = findViewById(R.id.radioButtonChinese);
 //       fast_food = findViewById(R.id.radioButtonFastFood);

    }

    public void addConfirm(View v) {
        String foodName = name.getText().toString();
        String foodDescription = description.getText().toString();
        String foodPrice = price.getText().toString();
//        String banglaFood = bangla.getText().toString();
//        String chineseFood = chinese.getText().toString();
//        String fastFood = fast_food.getText().toString();



        if(foodName.isEmpty()){
            name.setError("Please enter food name");
            name.requestFocus();
        }
        else if(foodDescription.isEmpty()){
            description.setError("Please write description about the food");
            description.requestFocus();
        }
        else if(foodPrice.isEmpty()){
            price.setError("Please enter the price");
            price.requestFocus();
        }

        else if(!(foodName.isEmpty() && foodDescription.isEmpty() && foodPrice.isEmpty())){

            //Set title of progress bar
            pd.setTitle("Adding Data");
            //Show progress bar when user click confirm button
            pd.show();

            chefID = mFirebaseAuth.getCurrentUser().getEmail() + UUID.randomUUID().toString();
            DocumentReference documentReference = db.collection("Chef_Item").document(chefID);

            Map<String,Object> item = new HashMap<>();
            item.put("Name", foodName );
            item.put("Descriprion", foodDescription );
            item.put("Price", foodPrice );
       //     item.put("Phone", chefPhone );

            //add data
            documentReference.set(item).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    // this will be called when data is added successfully
                    pd.dismiss();
                    Toast.makeText(Chef_AddItem.this,"Posted Successfully",Toast.LENGTH_SHORT).show();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    // this will be called if there is error while uploading

                    Toast.makeText(Chef_AddItem.this, e.getMessage() ,Toast.LENGTH_SHORT).show();

                }
            });
        }
        else{
            Toast.makeText(Chef_AddItem.this,"Error Occurred!",Toast.LENGTH_SHORT).show();
        }

    }


    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_Kitchen.class));
    }
}
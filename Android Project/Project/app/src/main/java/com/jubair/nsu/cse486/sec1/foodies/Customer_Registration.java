package com.jubair.nsu.cse486.sec1.foodies;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;

import java.util.HashMap;
import java.util.Map;


public class Customer_Registration extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText name,phoneNo, emailid, password;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore db;
    String customerID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        mFirebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        name = findViewById(R.id.editTextTextPersonName5);
        phoneNo = findViewById(R.id.editTextPhone6);
        emailid = findViewById(R.id.editTextEmailCustomer);
        password = findViewById(R.id.editTextPasswordCustomer);
        btnSignUp = findViewById(R.id.btnCustomerConfirm);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                String customerName = name.getText().toString();
                String customerPhone = phoneNo.getText().toString();



                if(email.isEmpty()){
                    emailid.setError("Please enter phone number");
                    emailid.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Customer_Registration.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Customer_Registration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Customer_Registration.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                customerID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = db.collection("Chef").document(customerID);

                                Map<String,Object> chef = new HashMap<>();
                                chef.put("Name", customerName );
                                chef.put("Phone", customerPhone );
                                chef.put("Email", email );
                                chef.put("Password", pwd );

                                documentReference.set(chef).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "OnSuccess: Chef Profile is created for "+customerID);
                                    }
                                });

                                Toast.makeText(Customer_Registration.this,"Registered Successfully as customer",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Customer_Registration.this, Customer_Homepage.class));
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Customer_Registration.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }



    public void GoBack(View v) {
        startActivity(new Intent(this, Customer_login.class));
    }
}

package com.jubair.nsu.cse486.sec1.foodies;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseUser;
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;
import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Homepage;

public class Customer_login extends AppCompatActivity {

    EditText emailid, password;
    Button btnSignIn;
    ProgressDialog pd;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        mFirebaseAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);

        emailid = findViewById(R.id.editTextTextEmailAddressCustomer);
        password = findViewById(R.id.editTextTextPassword3);
        btnSignIn = findViewById(R.id.btnCustomerLogin);

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser mFirebaseUser = mFirebaseAuth.getCurrentUser();
                if( mFirebaseUser != null ){
                    Toast.makeText(Customer_login.this,"You are logged in",Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Customer_login.this, Customer_Homepage.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(Customer_login.this,"Please Login",Toast.LENGTH_SHORT).show();
                }
            }
        };

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String pwd = password.getText().toString();

                if(email.isEmpty()){
                    emailid.setError("Please enter Phone");
                    emailid.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Customer_login.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.signInWithEmailAndPassword(email, pwd).addOnCompleteListener(Customer_login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Customer_login.this,"Login Error, Please Login Again",Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Customer_login.this,"Signed in Successfully",Toast.LENGTH_SHORT).show();
                                Intent intToHome = new Intent(Customer_login.this,Customer_Homepage.class);
                                startActivity(intToHome);
                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Customer_login.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }

            }
        });

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

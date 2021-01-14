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
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;

import java.util.HashMap;
import java.util.Map;

public class Chef_Registration extends AppCompatActivity {

    public static final String TAG = "TAG";
    EditText name,tong,address,phoneNo, emailid, password;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;
    FirebaseFirestore db;
    String chefID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_registration);

        mFirebaseAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        name = findViewById(R.id.editTextName);
        tong = findViewById(R.id.editTextTongName);
        address = findViewById(R.id.editTextAddress);
        phoneNo = findViewById(R.id.editTextPhoneChef);
        emailid = findViewById(R.id.editTextChefEmail);
        password = findViewById(R.id.editTextPasswordChef);

        btnSignUp = findViewById(R.id.btnChefConfirm);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailid.getText().toString();
                String pwd = password.getText().toString();
                String chefName = name.getText().toString();
                String tongName = tong.getText().toString();
                String chefAddress = address.getText().toString();
                String chefPhone = phoneNo.getText().toString();

                if(chefName.isEmpty()){
                    name.setError("Please enter your name");
                    name.requestFocus();
                }
                else if(tongName.isEmpty()){
                    tong.setError("Please enter your tong name");
                    tong.requestFocus();
                }
                else if(chefPhone.isEmpty()){
                    phoneNo.setError("Please enter your phone number");
                    phoneNo.requestFocus();
                }
                else if(email.isEmpty()){
                    emailid.setError("Please enter email address");
                    emailid.requestFocus();
                }
                else  if(pwd.isEmpty()){
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(email.isEmpty() && pwd.isEmpty()){
                    Toast.makeText(Chef_Registration.this,"Fields Are Empty!",Toast.LENGTH_SHORT).show();
                }
                else  if(!(email.isEmpty() && pwd.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(Chef_Registration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful()){
                                Toast.makeText(Chef_Registration.this,"SignUp Unsuccessful, Please Try Again",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                chefID = mFirebaseAuth.getCurrentUser().getUid();
                                DocumentReference documentReference = db.collection("Chef").document(chefID);

                                Map <String,Object> chef = new HashMap<>();
                                chef.put("ChefName", chefName );
                                chef.put("TongName", tongName );
                                chef.put("Address", chefAddress );
                                chef.put("Phone", chefPhone );
                                chef.put("Email", email );
                                chef.put("Password", pwd );

                                documentReference.set(chef).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        Log.d(TAG, "OnSuccess: Chef Profile is created for "+chefID);
                                    }
                                });

                                Toast.makeText(Chef_Registration.this,"Registered Successfully as chef",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(Chef_Registration.this, Chef_Homepage.class));

                            }
                        }
                    });
                }
                else{
                    Toast.makeText(Chef_Registration.this,"Error Occurred!",Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    public void GoBack(View v) {
        startActivity(new Intent(this, Chef_login.class));
    }


}

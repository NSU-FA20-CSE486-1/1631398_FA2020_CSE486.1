package com.jubair.nsu.cse486.sec1.foodies;

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
import com.jubair.nsu.cse486.sec1.foodies.Chef.Chef_Homepage;

public class Chef_Registration extends AppCompatActivity {

    EditText name,tong,address,phoneNo, emailid, password;
    Button btnSignUp;
    FirebaseAuth mFirebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chef_registration);

        mFirebaseAuth = FirebaseAuth.getInstance();
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
                String pwd = emailid.getText().toString();
                if(email.isEmpty()){
                    emailid.setError("Please enter phone number");
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

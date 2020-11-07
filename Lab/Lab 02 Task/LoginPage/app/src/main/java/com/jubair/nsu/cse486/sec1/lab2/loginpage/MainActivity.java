package com.jubair.nsu.cse486.sec1.lab2.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button btnLogin;

    String userid = "jubair";
    String pass = "123qwe";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnLogin =findViewById(R.id.button);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(password.getText().toString())){
                    Toast.makeText(MainActivity.this, "Empty data provided", Toast.LENGTH_LONG).show();
                }
                else if(username.getText().toString().equals(userid)){
                    //checking password
                    if(password.getText().toString().equals(pass)){
                        Toast.makeText(MainActivity.this, "Login Successful!", Toast.LENGTH_LONG).show();
                    }
                }
                else{
                    Toast.makeText(MainActivity.this, "Invalid username/password", Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}
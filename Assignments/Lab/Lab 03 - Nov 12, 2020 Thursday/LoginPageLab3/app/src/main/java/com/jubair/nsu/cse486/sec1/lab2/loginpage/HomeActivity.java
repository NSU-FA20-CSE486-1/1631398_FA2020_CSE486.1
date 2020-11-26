package com.jubair.nsu.cse486.sec1.lab2.loginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        btnLogout =findViewById(R.id.button2);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomeActivity.this, "Logged Out!", Toast.LENGTH_LONG).show();
                OpenStart();

            }
        });
    }

    public void OpenStart() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
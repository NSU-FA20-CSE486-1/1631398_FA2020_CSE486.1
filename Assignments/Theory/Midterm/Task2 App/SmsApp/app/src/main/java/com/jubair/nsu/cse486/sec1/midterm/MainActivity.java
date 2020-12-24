package com.jubair.nsu.cse486.sec1.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.jubair.nsu.cse486.sec1.midterm.MESSAGE";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendMessage(View view) {
        Intent i = new Intent(this, SecondActivity.class);
        EditText writeMsg = (EditText) findViewById(R.id.editText_WriteMsg);
        String message = writeMsg.getText().toString();
        i.putExtra(EXTRA_MESSAGE, message);
        startActivity(i);
    }


}
package com.jubair.nsu.cse486.sec1.midterm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.jubair.nsu.cse486.sec1.midterm.MESSAGE";
    public static final String EXTRA_ITEMS = "com.jubair.nsu.cse486.sec1.midterm.ITEMS";
    EditText writeMsg;
    EditText key;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        writeMsg =  findViewById(R.id.editText_WriteMsg);
        key =  findViewById(R.id.editText_WriteKey);
    }

    public String encrypt(String plainText, String secretKey) {
        StringBuffer encryptedString = new StringBuffer();
        int encryptedInt;
        for (int i = 0; i < plainText.length(); i++) {
            int plainTextInt = (int) (plainText.charAt(i) - 'A');
            int secretKeyInt = 3;
            encryptedInt = (plainTextInt + secretKeyInt) % 26;
            encryptedString.append((char) ((encryptedInt) + (int) 'A'));
        }
        return encryptedString.toString();
    }


    public void sendMessage(View view) {
        String plaintext = writeMsg.getText().toString();
        String secretkey = key.getText().toString();
        String encryptedText = encrypt( plaintext , secretkey);

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(EXTRA_MESSAGE, encryptedText);
        i.putExtra(EXTRA_ITEMS, secretkey);
        startActivity(i);
    }


}
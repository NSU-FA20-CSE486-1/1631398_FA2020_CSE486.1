package com.jubair.nsu.cse486.sec1.midterm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView encryptedtext;
    TextView decryptedtext;
    TextView key;
    EditText key2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String message2 = intent.getStringExtra(MainActivity.EXTRA_ITEMS);

        encryptedtext = findViewById(R.id.EncryptedText);
        encryptedtext.setText(message);

        key = findViewById(R.id.GetKey);
        key.setText(message2);

        key2 = findViewById(R.id.DecryptKey);
    }


    public String decrypt(String decryptedText, String secretKey) {
        StringBuffer decryptedString = new StringBuffer();
        int decryptedInt;
        for (int i = 0; i < decryptedText.length(); i++) {
            int decryptedTextInt = (int) (decryptedText.charAt(i) - 'A');
            int secretKeyInt = (int) (secretKey.charAt(i) - 'A');
            decryptedInt = decryptedTextInt - secretKeyInt;
            if (decryptedInt < 1)
                decryptedInt += 26;
            decryptedString.append((char) ((decryptedInt) + (int) 'A'));
        }
        return decryptedString.toString();
    }


    public void decryptMessage(View view) {

        String plaintext = encryptedtext.getText().toString();
        String secretkey = key2.getText().toString();
        String encryptedText = decrypt( plaintext , secretkey);
        decryptedtext = findViewById(R.id.DecryptedText);
        decryptedtext.setText(encryptedText);

    }

}

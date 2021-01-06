package com.jubair.nsu.cse486.sec1.quiz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.jubair.nsu.cse486.sec1.midterm.MESSAGE";
    public static final String EXTRA_ITEMS = "com.jubair.nsu.cse486.sec1.midterm.ITEMS";
    EditText englishWord;
    EditText banglaWord;

    // LinkedList to hold the data
    private final LinkedList<String> mWordList = new LinkedList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        englishWord = findViewById(R.id.editText_english);
        banglaWord = findViewById(R.id.editText_bangla);
    }


    public void Save(View v){
        String english = englishWord.getText().toString();
        String bangla = banglaWord.getText().toString();

        Intent i = new Intent(this, WordListAdapter.class);
        i.putExtra(EXTRA_MESSAGE, english);
        i.putExtra(EXTRA_ITEMS, bangla);

    }

    public void Dictionary(View v){
        Intent i = new Intent(this, WordListAdapter.class);
        startActivity(i);
    }
}
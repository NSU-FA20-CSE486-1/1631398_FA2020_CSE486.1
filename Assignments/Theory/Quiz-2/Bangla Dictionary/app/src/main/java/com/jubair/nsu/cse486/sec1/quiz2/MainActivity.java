package com.jubair.nsu.cse486.sec1.quiz2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.jubair.nsu.cse486.sec1.quiz2.MESSAGE";
    public static final String EXTRA_ITEMS = "com.jubair.nsu.cse486.sec1.quiz2.ITEMS";

    private final ArrayList<String> list = new ArrayList<>();
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    EditText englishWord;
    EditText banglaWord;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        englishWord = findViewById(R.id.editText_english);
        banglaWord = findViewById(R.id.editText_bangla);
    }



    public void Save(View v){
        String englishTxt = englishWord.getText().toString();
        String banglaTxt = banglaWord.getText().toString();

        Intent i = new Intent(this, SecondActivity.class);
        i.putExtra(EXTRA_MESSAGE, englishTxt);

        Intent i2 = new Intent(this, WordListAdapter.class);
        i.putExtra(EXTRA_ITEMS, banglaTxt);
    }

    public void Dictionary(View v){
        Intent i = new Intent(this, SecondActivity.class);
        startActivity(i);
    }
}
package com.jubair.nsu.cse486.sec1.quiz2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.LinkedList;
import java.util.Objects;

public class SecondActivity extends AppCompatActivity {


    // LinkedList to hold the data
    private final LinkedList<String> list = new LinkedList<>();
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mRecyclerView = findViewById(R.id.recyclerView);

        Intent intent = getIntent();
        String englishWord = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String banglaWord = intent.getStringExtra(MainActivity.EXTRA_ITEMS);

        int wordListSize = list.size();
        list.addLast(englishWord);

        mRecyclerView.smoothScrollToPosition(wordListSize);
        WordListAdapter mAdapter = new WordListAdapter(this, list);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
}


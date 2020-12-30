package com.jubair.nsu.cse486.sec1.lab9.AsyncTaskAndAsynctaskLoader;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView TextView;
    private TextView ProgressText;
    private static final String TEXT_STATE = "CurrentText";
    private static final String TEXT_PROGRESS = "CurrentSleepDuration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView = findViewById(R.id.textView1);
        ProgressText = findViewById(R.id.textViewResult);

        if (savedInstanceState != null){
            TextView.setText(savedInstanceState.getString(TEXT_STATE));
            ProgressText.setText(savedInstanceState.getString(TEXT_PROGRESS));
        }
    }


    public void startTask(View view) {
        TextView.setText(R.string.loading);
        new MyAsyncTask(TextView, ProgressText).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(TEXT_STATE, TextView.getText().toString());
        outState.putString(TEXT_PROGRESS, ProgressText.getText().toString());
    }

}
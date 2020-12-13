package JubairAhmed.lab7.DateAndTime;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static String ConfirmText;
    public static final String EXTRA_MESSAGE = "JubairAhmed.lab7.DateAndTime.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void showConfirm(View view) {
        OpenSecond();

    }

    public void showTimePicker(View view) {
        DialogFragment fragment = new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), getString(R.string.time_picker));

    }

    public void showDatePicker(View view) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(),"datePicker");

    }


    public void processTimePickerResult(int hour, int minute){
        String hour_string = Integer.toString(hour);
        String minute_string = Integer.toString(minute);
        String time_message = hour_string + ":" + minute_string;
        Toast.makeText(getApplicationContext(), "Time: " + time_message, Toast.LENGTH_SHORT).show();
        ConfirmText = getString(R.string.time_picker);
    }

    public void processDatePickerResult(int year, int month, int dayOfMonth){
        String year_string = Integer.toString(year);
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(dayOfMonth);
        String date_message = day_string + "/" + month_string + "/" + year_string;
        Toast.makeText(getApplicationContext(), "Date: " + date_message, Toast.LENGTH_SHORT).show();

    }

    public void OpenSecond() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }





}

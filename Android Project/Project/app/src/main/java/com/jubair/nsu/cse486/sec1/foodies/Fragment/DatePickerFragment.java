package com.jubair.nsu.cse486.sec1.foodies.Fragment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import androidx.annotation.NonNull;

import androidx.fragment.app.DialogFragment;

import com.jubair.nsu.cse486.sec1.foodies.Customer.Customer_Event;

import java.util.Calendar;
import java.util.Objects;


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener
{
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(Objects.requireNonNull(getActivity()), this, year, month, dayOfMonth);
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Customer_Event activity = (Customer_Event) getActivity();
        if (activity != null) {
            activity.processDatePickerResult(year, month, dayOfMonth);
        }
    }
}

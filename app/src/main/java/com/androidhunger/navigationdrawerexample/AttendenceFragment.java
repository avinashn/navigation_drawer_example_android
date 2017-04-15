package com.androidhunger.navigationdrawerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Avinash on 11-03-2017.
 */
public class AttendenceFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    TextView textView;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Spinner spinner = (Spinner) view.findViewById(R.id.semSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.semisters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
       textView = (TextView) view.findViewById(R.id.tvResult);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.attendence, container, false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
String semester = parent.getItemAtPosition(position).toString();

        if (semester.equals("Semister 1")){
            textView.setText("Your attendence for this Semister is 82%");
        }
        else if (semester.equals("Semister 2")){
            textView.setText("Your attendence for this Semister is 86.8%");
        }
        else if (semester.equals("Semister 3")){
            textView.setText("Your attendence for this Semister is 73.8% as of now.");
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

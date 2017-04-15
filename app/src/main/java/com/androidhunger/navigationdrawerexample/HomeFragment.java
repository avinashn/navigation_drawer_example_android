package com.androidhunger.navigationdrawerexample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by Avinash on 11-03-2017.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button tt = (Button) getView().findViewById(R.id.btnTimeTable);
        Button atn = (Button) getView().findViewById(R.id.btnAttenence);
        Button exmSc = (Button) getView().findViewById(R.id.btnExamScheule);
        Button res = (Button) getView().findViewById(R.id.btnResults);

        atn.setOnClickListener(this);
        exmSc.setOnClickListener(this);
        res.setOnClickListener(this);
        tt.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.home, container, false);

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        switch (v.getId()) {
            case R.id.btnTimeTable:
                fragment = new TimeTableFragment();
                break;
            case R.id.btnExamScheule:
                fragment = new ExamScheduleFragment();
                break;
            case R.id.btnResults:
                fragment = new ResultFragment();
                break;
            case R.id.btnAttenence:
                fragment = new AttendenceFragment();
                break;
        }
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .addToBackStack(null)
                .commit();
    }
}

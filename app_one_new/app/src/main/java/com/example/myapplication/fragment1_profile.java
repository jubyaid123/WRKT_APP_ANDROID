package com.example.myapplication;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class fragment1_profile extends Fragment {



    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("PREFERENCE", MODE_PRIVATE);
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // Got user information from FirstRun activity and displayed it
        TextView textView = view.findViewById(R.id.name_display);
        textView.setText(sharedPreferences.getString("name", "USER"));
        textView = view.findViewById(R.id.height_display);
        textView.setText(sharedPreferences.getString("height", "HEIGHT"));
        textView = view.findViewById(R.id.weight_display);
        textView.setText(sharedPreferences.getString("weight", "WEIGHT"));
        Button oneRep = (Button) view.findViewById(R.id.one_rep_max_calculator);
        Button bmi =  view.findViewById(R.id.bmi);

        oneRep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RepsCalculatorActivity.class);
                getActivity().startActivity(intent);
            }

        });

        bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), BmiActivity.class);
                getActivity().startActivity(intent);
            }

        });


        return view;
    }
}
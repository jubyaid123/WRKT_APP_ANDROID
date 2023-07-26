package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.myapplication.databinding.OneRepLayoutBinding;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class RepsCalculatorActivity extends AppCompatActivity implements View.OnClickListener {
    OneRepLayoutBinding oneRepLayoutBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        oneRepLayoutBinding = OneRepLayoutBinding.inflate(getLayoutInflater());
        setContentView(oneRepLayoutBinding.getRoot());
        oneRepLayoutBinding.oneRepBackBtn.setOnClickListener(this);
        oneRepLayoutBinding.calculateOneRepBtn.setOnClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        if (view == oneRepLayoutBinding.oneRepBackBtn) {
            onBackPressed();
        }

        if (view == oneRepLayoutBinding.calculateOneRepBtn) {
            String reps = oneRepLayoutBinding.reps.getText().toString();
            String lift = oneRepLayoutBinding.liftLb.getText().toString();
            if (reps.trim().equals("") || lift.trim().equals("")) {
                Toast.makeText(this, "Make sure to fill in all boxes", Toast.LENGTH_LONG).show();
                return;
            }

            int reps_int = Integer.parseInt(reps);
            int lift_int = Integer.parseInt(lift);
            double OneRepMax = oneRepMaxCalc(lift_int, reps_int);
            oneRepLayoutBinding.repInfo.setVisibility(RelativeLayout.VISIBLE);
            repsCalc temp = new repsCalc(OneRepMax);
            repsCalc[] allReps = temp.getAllReps();

            ListView listView = findViewById(R.id.reps_listview);
            RepsListAdapter adapter = new RepsListAdapter(this, R.layout.list_rep_layout, allReps);
            listView.setAdapter(adapter);

        }
    }

    private double oneRepMaxCalc(int lift_int, int reps_int) {
        // using The Brzycki Equation
        return (double) lift_int / (1.0278 - (0.0278 * reps_int));
    }
}


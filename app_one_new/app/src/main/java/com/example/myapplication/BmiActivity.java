package com.example.myapplication;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.example.myapplication.databinding.DialogBmiBinding;
import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BmiActivity extends AppCompatActivity implements View.OnClickListener {

    DialogBmiBinding dialog;

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setFinishOnTouchOutside(false);
        dialog = DialogBmiBinding.inflate(getLayoutInflater());
        setContentView(dialog.getRoot());
        dialog.calculateBm.setOnClickListener(this);
        dialog.exitDialog.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        if (view == dialog.calculateBm) {
            String currWeight = dialog.currentWeight.getText().toString();
            if (currWeight.trim().equals("")) {
                Toast.makeText(this, "Please give current weight", Toast.LENGTH_LONG).show();
                return;
            }
            SharedPreferences sharedPreferences = getSharedPreferences("PREFERENCE", MODE_PRIVATE);
            MathContext m = new MathContext(4);
            BigDecimal weight = new BigDecimal(currWeight);
            BigDecimal height_in = new BigDecimal(sharedPreferences.getString("height", "0")).multiply(BigDecimal.valueOf(0.393701), m);
            double bmi = (weight.divide(height_in.multiply(height_in, m), m)).multiply(BigDecimal.valueOf(703), m).doubleValue();

            dialog.bmiNum.setText(Double.toString(bmi));
            dialog.bmiNum.setVisibility(View.VISIBLE);

            if (bmi < 18.5) dialog.bmiStatus.setText("Underweight");
            else if (bmi >= 18.5 && bmi <= 24.9) dialog.bmiStatus.setText("Healthy Weight");
            else if (bmi >= 25.0 && bmi <= 29.9) dialog.bmiStatus.setText("Overweight");
            else dialog.bmiStatus.setText("Obesity");
            dialog.bmiStatus.setVisibility(View.VISIBLE);
        }

        if (view == dialog.exitDialog) {
            finish();
        }
    }
}

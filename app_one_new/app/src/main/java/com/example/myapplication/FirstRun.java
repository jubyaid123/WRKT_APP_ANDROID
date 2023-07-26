package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.myapplication.databinding.FirstRunLayoutBinding;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class FirstRun extends AppCompatActivity implements View.OnClickListener {

    FirstRunLayoutBinding firstRunLayoutBinding;
    //public static boolean submitBtn = false;

    @Override
    protected void onCreate (@Nullable Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        firstRunLayoutBinding = FirstRunLayoutBinding.inflate(getLayoutInflater());
        setContentView(firstRunLayoutBinding.getRoot());
        firstRunLayoutBinding.submitBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        if (view == firstRunLayoutBinding.submitBtn) {
            String name = firstRunLayoutBinding.UserName.getText().toString();
            String height_cm = firstRunLayoutBinding.heightData.getText().toString();
            String weight = firstRunLayoutBinding.weightData.getText().toString();

            if (name.trim().equals("") || height_cm.trim().equals("") || weight.trim().equals("")) {
                Toast.makeText(this, "Make sure to fill in all boxes", Toast.LENGTH_LONG).show();
                return;
            }

            SharedPreferences.Editor editor = (SharedPreferences.Editor) getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit();
            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit().putBoolean("isFirstRun", false).commit();
            editor.putString("name", name);
            editor.putString("height", height_cm);
            editor.putString("weight", weight);
            editor.commit();
            //submitBtn = true;
            Intent intent = new Intent(getBaseContext(), MainActivity.class);
            startActivity(intent);
        }

    }
}

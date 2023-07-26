package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.workouts_exercises.Workout;

public class DisplayWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_workout);
        Intent intent = getIntent();
        Workout selectedWorkout = (Workout) intent.getSerializableExtra("workout");
        TextView workoutNameEditText = findViewById(R.id.edtTxtWorkoutName);
        TextView exerciseOneEditText =  findViewById(R.id.edtTxtWorkoutOne);
        TextView exerciseTwoEditText =  findViewById(R.id.edtTxtWorkoutTwo);
        TextView exerciseThreeEditText =  findViewById(R.id.edtTxtWorkoutThree);
        TextView exerciseFourEditText =  findViewById(R.id.edtTxtWorkoutFour);
        TextView exerciseFiveEditText =  findViewById(R.id.edtTxtWorkoutFive);
        //Getting Sets ID
        TextView exerciseOneSetEditText =  findViewById(R.id.edtTxtSetWorkoutOne);
        TextView exerciseTwoSetEditText =  findViewById(R.id.edtTxtSetWorkoutTwo);
        TextView exerciseThreeSetEditText =  findViewById(R.id.edtTxtSetWorkoutThree);
        TextView exerciseFourSetEditText =  findViewById(R.id.edtTxtSetWorkoutFour);
        TextView exerciseFiveSetEditText =  findViewById(R.id.edtTxtSetWorkoutFive);
        //getting Reps ID
        TextView exerciseOneRepEditText =  findViewById(R.id.edtTxtRepWorkoutOne);
        TextView exerciseTwoRepEditText =  findViewById(R.id.edtTxtRepWorkoutTwo);
        TextView exerciseThreeRepEditText =  findViewById(R.id.edtTxtRepWorkoutThree);
        TextView exerciseFourRepEditText =  findViewById(R.id.edtTxtRepWorkoutFour);
        TextView exerciseFiveRepEditText =  findViewById(R.id.edtTxtRepWorkoutFive);

        //SetText WorkoutName
        workoutNameEditText.setText(selectedWorkout.getName());
        //SetText Exercises
        exerciseOneEditText.setText(selectedWorkout.getExercises().get(0).getName());
        exerciseTwoEditText.setText(selectedWorkout.getExercises().get(1).getName());
        exerciseThreeEditText.setText(selectedWorkout.getExercises().get(2).getName());
        exerciseFourEditText.setText(selectedWorkout.getExercises().get(3).getName());
        exerciseFiveEditText.setText(selectedWorkout.getExercises().get(4).getName());
        //SetText Sets
        exerciseOneSetEditText.setText(selectedWorkout.getExercises().get(0).getSets());
        exerciseTwoSetEditText.setText(selectedWorkout.getExercises().get(1).getSets());
        exerciseThreeSetEditText.setText(selectedWorkout.getExercises().get(2).getSets());
        exerciseFourSetEditText.setText(selectedWorkout.getExercises().get(3).getSets());
        exerciseFiveSetEditText.setText(selectedWorkout.getExercises().get(4).getSets());
        //SetText Reps
        exerciseOneRepEditText.setText(selectedWorkout.getExercises().get(0).getReps());
        exerciseTwoRepEditText.setText(selectedWorkout.getExercises().get(1).getReps());
        exerciseThreeRepEditText.setText(selectedWorkout.getExercises().get(2).getReps());
        exerciseFourRepEditText.setText(selectedWorkout.getExercises().get(3).getReps());
        exerciseFiveEditText.setText(selectedWorkout.getExercises().get(4).getReps());

        //Back Button
        Button backButton = findViewById(R.id.DisplayWorkoutBackBtn);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });





    }


}
package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import com.example.myapplication.workouts_exercises.Workout;
import com.example.myapplication.workouts_exercises.Exercise;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class fragment2_createWokrout extends Fragment {
    ArrayList<Workout> workouts = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_fragment2, container, false);

        ListView listViewWorkouts = rootView.findViewById(R.id.listViewWorkouts);
        adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,android.R.id.text1);
        listViewWorkouts.setAdapter(adapter);

        listViewWorkouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(workouts.isEmpty()){

                }else{
                    Workout selectedWorkout = workouts.get(position);
                    Intent intent = new Intent(fragment2_createWokrout.this.getActivity(), DisplayWorkout.class);
                    intent.putExtra("workout",selectedWorkout);
                    startActivity(intent);
                }
            }
        });

        Button createWorkoutButton = rootView.findViewById(R.id.btnCreate);
        createWorkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCreateWorkoutBtnClick();
            }
        });

        return rootView;
    }

    public void onCreateWorkoutBtnClick() {
        //Getting Workout Name ID
        EditText workoutNameEditText = getView().findViewById(R.id.edtTxtWorkoutName);
        //Getting Exercise Name ID
        EditText exerciseOneEditText = getView().findViewById(R.id.edtTxtWorkoutOne);
        EditText exerciseTwoEditText = getView().findViewById(R.id.edtTxtWorkoutTwo);
        EditText exerciseThreeEditText = getView().findViewById(R.id.edtTxtWorkoutThree);
        EditText exerciseFourEditText = getView().findViewById(R.id.edtTxtWorkoutFour);
        EditText exerciseFiveEditText = getView().findViewById(R.id.edtTxtWorkoutFive);
        //Getting Sets ID
        EditText exerciseOneSetEditText = getView().findViewById(R.id.edtTxtSetWorkoutOne);
        EditText exerciseTwoSetEditText = getView().findViewById(R.id.edtTxtSetWorkoutTwo);
        EditText exerciseThreeSetEditText = getView().findViewById(R.id.edtTxtSetWorkoutThree);
        EditText exerciseFourSetEditText = getView().findViewById(R.id.edtTxtSetWorkoutFour);
        EditText exerciseFiveSetEditText = getView().findViewById(R.id.edtTxtSetWorkoutFive);
        //getting Reps ID
        EditText exerciseOneRepEditText = getView().findViewById(R.id.edtTxtRepWorkoutOne);
        EditText exerciseTwoRepEditText = getView().findViewById(R.id.edtTxtRepWorkoutTwo);
        EditText exerciseThreeRepEditText = getView().findViewById(R.id.edtTxtRepWorkoutThree);
        EditText exerciseFourRepEditText = getView().findViewById(R.id.edtTxtRepWorkoutFour);
        EditText exerciseFiveRepEditText = getView().findViewById(R.id.edtTxtRepWorkoutFive);


        // Initializing Workout Name
        String workoutName = workoutNameEditText.getText().toString();
        // Initialing Exercise Names
        String exerciseOne = exerciseOneEditText.getText().toString();
        String exerciseTwo = exerciseTwoEditText.getText().toString();
        String exerciseThree = exerciseThreeEditText.getText().toString();
        String exerciseFour = exerciseFourEditText.getText().toString();
        String exerciseFive = exerciseFiveEditText.getText().toString();
        //Initializing Sets
        String exerciseOneSets = exerciseOneSetEditText.getText().toString();
        String exerciseTwoSets = exerciseTwoSetEditText.getText().toString();
        String exerciseThreeSets = exerciseThreeSetEditText.getText().toString();
        String exerciseFourSets = exerciseFourSetEditText.getText().toString();
        String exerciseFiveSets = exerciseFiveSetEditText.getText().toString();
        //Initializing Reps
        String exerciseOneReps = exerciseOneRepEditText.getText().toString();
        String exerciseTwoReps = exerciseTwoRepEditText.getText().toString();
        String exerciseThreeReps = exerciseThreeRepEditText.getText().toString();
        String exerciseFourReps = exerciseFourRepEditText.getText().toString();
        String exerciseFiveReps = exerciseFiveRepEditText.getText().toString();

        //Create Workout Object and Add Info

        Workout workout1 = new Workout(workoutName);
        Exercise exercise1 = new Exercise(exerciseOne,exerciseOneSets,exerciseOneReps);
        Exercise exercise2 = new Exercise(exerciseTwo,exerciseTwoSets,exerciseTwoReps);
        Exercise exercise3 = new Exercise(exerciseThree,exerciseThreeSets,exerciseThreeReps);
        Exercise exercise4 = new Exercise(exerciseFour, exerciseFourSets, exerciseFourReps);
        Exercise exercise5 = new Exercise(exerciseFive, exerciseFiveSets, exerciseFiveReps);
        workout1.addExercise(exercise1);
        workout1.addExercise(exercise2);
        workout1.addExercise(exercise3);
        workout1.addExercise(exercise4);
        workout1.addExercise(exercise5);
        workouts.add(workout1);

        // Clear the EditText fields
        workoutNameEditText.getText().clear();
        exerciseOneEditText.getText().clear();
        exerciseTwoEditText.getText().clear();
        exerciseThreeEditText.getText().clear();
        exerciseFourEditText.getText().clear();
        exerciseFiveEditText.getText().clear();
        exerciseOneSetEditText.getText().clear();
        exerciseTwoSetEditText.getText().clear();
        exerciseThreeSetEditText.getText().clear();
        exerciseFourSetEditText.getText().clear();
        exerciseFiveSetEditText.getText().clear();
        exerciseOneRepEditText.getText().clear();
        exerciseTwoRepEditText.getText().clear();
        exerciseThreeRepEditText.getText().clear();
        exerciseFourRepEditText.getText().clear();
        exerciseFiveRepEditText.getText().clear();

        adapter.add(workout1.getName());


    }

}

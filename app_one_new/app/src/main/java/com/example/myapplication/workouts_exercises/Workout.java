package com.example.myapplication.workouts_exercises;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import com.example.myapplication.workouts_exercises.Exercise;

public class Workout implements Serializable {
    private String name;
    private List<Exercise> exercises;

    public Workout(String name) {
        this.name = name;
        this.exercises = new ArrayList<>();
    }

    public void addExercise(Exercise exercise) {
        this.exercises.add(exercise);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }
}

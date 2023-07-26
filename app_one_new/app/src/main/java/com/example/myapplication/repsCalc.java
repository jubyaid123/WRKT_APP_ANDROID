package com.example.myapplication;

import java.math.BigDecimal;

public class repsCalc {
    private int reps;
    private BigDecimal percentage;
    private BigDecimal maxWeight;

    public repsCalc(double oneRep) {
        maxWeight = BigDecimal.valueOf(oneRep);
        reps = 1;
        percentage = BigDecimal.valueOf(1);
    }

    public repsCalc() {
        reps = 0;
        percentage = BigDecimal.valueOf(0);
        maxWeight = BigDecimal.valueOf(0);
    }
    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public BigDecimal getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(BigDecimal maxWeight) {
        this.maxWeight = maxWeight;
    }

    public repsCalc[] getAllReps() {
        repsCalc[] ans = new repsCalc[11];
        ans[0] = new repsCalc(this.maxWeight.doubleValue());

        BigDecimal maxWeight = ans[0].getMaxWeight();
        int repsCnt = 2;
        BigDecimal percent = BigDecimal.valueOf(0.95);

        ans[1] = new repsCalc();
        ans[1].setReps(repsCnt);
        ans[1].setMaxWeight(maxWeight.multiply(percent));
        ans[1].setPercentage(percent);

        for (int i = 2; i <= 6; i++) {
            percent = percent.subtract(BigDecimal.valueOf(0.05));
            repsCnt = repsCnt + 2;
            ans[i] = new repsCalc(i);
            ans[i].setMaxWeight(maxWeight.multiply(percent));
            ans[i].setPercentage(percent);
            ans[i].setReps(repsCnt);
        }

        for (int i = 7; i <= 9; i++) {
            percent = percent.subtract(BigDecimal.valueOf(0.05));
            repsCnt = repsCnt + 4;
            ans[i] = new repsCalc(i);
            ans[i].setMaxWeight(maxWeight.multiply(percent));
            ans[i].setPercentage(percent);
            ans[i].setReps(repsCnt);
        }

        ans[10] = new repsCalc();
        ans[10].setReps(30);
        ans[10].setMaxWeight(maxWeight.multiply(percent));
        ans[10].setPercentage(BigDecimal.valueOf(0.5));

        return ans;
    }
}

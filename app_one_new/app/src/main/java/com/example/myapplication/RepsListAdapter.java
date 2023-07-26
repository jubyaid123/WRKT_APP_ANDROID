package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class RepsListAdapter extends ArrayAdapter<repsCalc> {
    private Context mContext;
    int mResource;

    public RepsListAdapter(Context context, int resource, repsCalc[] repsCalcs) {
        super(context, resource, repsCalcs);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView (int position, View convertView, ViewGroup parent) {
        String reps = String.valueOf(getItem(position).getReps());
        String maxWeight = getItem(position).getMaxWeight().setScale(2, RoundingMode.HALF_UP).toString();
        String percent = getItem(position).getPercentage().multiply(BigDecimal.valueOf(100)).setScale(2, RoundingMode.HALF_UP).toString();

        repsCalc repsCalc = new repsCalc();

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView rpCnt = (TextView) convertView.findViewById(R.id.rep_cnt);
        TextView max = (TextView) convertView.findViewById(R.id.max_weight);
        TextView per = (TextView) convertView.findViewById(R.id.percentage);

        rpCnt.setText(reps);
        max.setText(maxWeight);
        per.setText(percent);

        return convertView;

    }

}

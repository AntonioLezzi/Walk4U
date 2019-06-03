package com.example.walk4you.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.walk4you.R;

    public class HolderPasti extends RecyclerView.ViewHolder {

    TextView textViewKalBru;
    TextView textViewCalAss;
    TextView textViewPeso;
    TextView textViewData12;
    TextView textViewCarbG;
    TextView TextViewProtG;
    TextView textViewZuccheroG;
    TextView TextViewGrassiG;
    TextView textViewVitamineG;


    public HolderPasti (View itemView) {
        super(itemView);

        textViewKalBru = itemView.findViewById(R.id.textViewKalBru);
        textViewCalAss = itemView.findViewById(R.id.textViewCalAss);
        textViewPeso = itemView.findViewById(R.id.textViewPeso);
        textViewData12 = itemView.findViewById(R.id.textViewData12);
        textViewCarbG = itemView.findViewById(R.id.textViewCarbG);
        TextViewProtG = itemView.findViewById(R.id.TextViewProtG);
        textViewZuccheroG = itemView.findViewById(R.id.textViewZuccheroG);
        TextViewGrassiG = itemView.findViewById(R.id.TextViewGrassiG);
        textViewVitamineG = itemView.findViewById(R.id.textViewVitamineG);
    }

}
package com.example.walk4you.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.walk4you.R;

public class HolderInfoAtt extends RecyclerView.ViewHolder{

    TextView textViewPassiB;
    TextView textViewmedia1;
    TextView textViewData;
    TextView textViewN250;
    TextView textViewOre;
    TextView textViewKm;
    TextView textViewKcal;
    TextView textViewBPM1;

    public HolderInfoAtt (View itemView) {
        super(itemView);

        textViewPassiB = itemView.findViewById(R.id.textViewPassiB);
        textViewmedia1 = itemView.findViewById(R.id.textViewmedia1);
        textViewData = itemView.findViewById(R.id.textViewData12);
        textViewN250 = itemView.findViewById(R.id.textViewN250);
        textViewOre = itemView.findViewById(R.id.textViewOre);
        textViewKm = itemView.findViewById(R.id.textViewKm);
        textViewKcal = itemView.findViewById(R.id.textViewKcal);
        textViewBPM1 = itemView.findViewById(R.id.textViewBPM1);
    }

}

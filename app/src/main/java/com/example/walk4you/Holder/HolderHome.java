package com.example.walk4you.Holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import  com.example.walk4you.R;

 public class HolderHome extends RecyclerView.ViewHolder{

     TextView textViewPuntiBig;
     TextView textViewMedia;
     TextView textViewData;
     TextView textInfoAtt;
     TextView textViewKM2;
     TextView textViewKcal;
     TextView textViewPremi;

     public ContactDBAdapter (View itemView) {
         super(itemView);

         textViewPuntiBig = itemView.findViewById(R.id.textViewPuntiBig);
         textViewMedia = itemView.findViewById(R.id.textViewMedia);
         textViewData = itemView.findViewById(R.id.textViewData12);
         textInfoAtt = itemView.findViewById(R.id.textInfoAtt);
         textViewKM2 = itemView.findViewById(R.id.textViewKM2);
         textViewKcal = itemView.findViewById(R.id.textViewKcal);
         textViewPremi = itemView.findViewById(R.id.textViewPremi);
     }

 }

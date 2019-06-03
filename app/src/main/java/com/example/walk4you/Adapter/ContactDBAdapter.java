package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.walk4you.Helper.DatabaseHelper;
import com.example.walk4you.Holder.HolderHome;
import com.example.walk4you.R;

import java.util.ArrayList;
import java.util.List;

public class ContactDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

  /*  @NonNull
    @Override
    public ContactDBAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_home, parent, false);
        return new HolderHome(view);
    }
  */

}




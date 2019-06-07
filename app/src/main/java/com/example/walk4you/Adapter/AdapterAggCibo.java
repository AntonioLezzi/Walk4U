package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

public class AdapterAggCibo {
    @SuppressWarnings("unused")
    private static  final String LOG_TAG = AdapterUtente.class.getSimpleName();

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public AdapterAggCibo(Context context) { this.context = context;}

    public AdapterAggCibo open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
    }

}


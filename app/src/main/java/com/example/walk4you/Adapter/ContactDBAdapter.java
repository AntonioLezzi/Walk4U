package com.example.walk4you.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObservable;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.walk4you.Helper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;

public class ContactDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;

    public ContactDBAdapter (Context context) {
        this.context = context;
    }

    public ContactDBAdapter open() throws  SQLException {
    dbHelper = new DatabaseHelper(context);
    database = dbHelper.getWritableDatabase();

    return this;
    }

    public void close() {
            dbHelper.close();
            database.close();
        }

}



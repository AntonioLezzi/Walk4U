package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DBHelper dbHelper;

    public DBAdapter(Context context) {
        this.context = context;
    }




    public DBAdapter open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();

        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
}
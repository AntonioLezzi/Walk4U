package com.example.walk4you.Db_join;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.walk4you.Db_tabelle.DBHelper;

import java.sql.Date;

public class DbAlimentoPasto extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    public DbAlimentoPasto(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "alimento_pasto";
    private static final String COLUMN_ID = "id_pasto";
    private static final String COLUMN_ID_2 = "id_alimento";
    private static final Date COLUMN_DATA = Date.valueOf("data");

    private static final String CREATE_TABLE_ALIMENTO_PASTO = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_ID_2 + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " + COLUMN_DATA + " DATE )";



    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_ALIMENTO_PASTO);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS alimento_pasto");
        onCreate(database);
    }


    public DbAlimentoPasto open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = this.getWritableDatabase();
        return this;
    }
    public void close() {
        if (dbHelper != null) {
            dbHelper.close();
        }
    }}

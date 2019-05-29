package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBParametri extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "utente";
    private static final String COLUMN_ID = "id_parametri";
    private static final int COLUMN_PESO = Integer.parseInt("peso");
    private static final int COLUMN_BATTITO_CARDIACO = Integer.parseInt("battito_cardiaco");

    private static final String CREATE_TABLE_PARAMETRI = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_PESO + " INTEGER, " + COLUMN_BATTITO_CARDIACO + " INTEGER )";


    public DBParametri(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_PARAMETRI);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS parametri");
        onCreate(database);
    }


    public DBParametri open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = this.getWritableDatabase();
        return this;
    }
    public void close() {
        if(dbHelper!= null){
            dbHelper.close();
        }
    }

}

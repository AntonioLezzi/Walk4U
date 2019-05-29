package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DBRistorante extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "ristoranti";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_NAME = "nome";
    private static final String COLUMN_TIPOLOGIA = "tipologia";
    private static final double COLUMN_LATITUDINE= Double.parseDouble("latitudine");
    private static final double COLUMN_LONGITUDINE= Double.parseDouble("longitudine");

    private static final String CREATE_TABLE_RISTORANTI = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NAME + " TEXT, " + COLUMN_TIPOLOGIA + " TEXT )";


    public DBRistorante(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_RISTORANTI);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS ristoranti");
        onCreate(database);
    }


    public DBRistorante open() throws SQLException {
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

package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBAttività extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "attività";
    private static final String COLUMN_ID = "id_attività";
    private static final int COLUMN_NUMERO_PASSI = Integer.parseInt("numero_passi");
    private static final double COLUMN_ORE_SONNO = Double.parseDouble("ore_sonno");
    private static final double COLUMN_KM= Double.parseDouble("km");
    private static final int COLUMN_KCAL_BRUCIATE= Integer.parseInt("Kcal_bruciate");


    private static final String CREATE_TABLE_ATTIVITA = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUMERO_PASSI + " INTEGER, " + COLUMN_ORE_SONNO + "INTEGER, " + COLUMN_KM + "INTEGER, " + COLUMN_KCAL_BRUCIATE + " INTEGER )";


    public DBAttività(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_ATTIVITA);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS attività");
        onCreate(database);
    }


    public DBAttività open() throws SQLException {
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

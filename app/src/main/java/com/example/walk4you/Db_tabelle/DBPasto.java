package com.example.walk4you.Db_tabelle;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Date;

public class DBPasto extends SQLiteOpenHelper {

    public SQLiteDatabase database;
    public DBHelper dbHelper;
    public Context context;

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Database.db";
    private static final String TABLE_NAME = "pasto";
    private static final String COLUMN_ID = "id_pasto";
    private static final Boolean COLUMN_CENA = Boolean.valueOf("cena");
    private static final Boolean COLUMN_COLAZIONE = Boolean.valueOf("colazione");
    private static final Boolean COLUMN_PRANZO = Boolean.valueOf("pranzo");
    private static final Boolean COLUMN_SPUNTINO = Boolean.valueOf("spuntino");
    private static final Date COLUMN_DATA_INIZIO = Date.valueOf("data_inizio");
    private static final Date COLUMN_DATA_FINE = Date.valueOf("data_fine");
    private static final String COLUMN_ALIMENTO = "alimento";


    private static final String CREATE_TABLE_PASTO = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CENA + " TEXT, " + COLUMN_PRANZO + "TEXT, " + COLUMN_SPUNTINO + "TEXT, " + COLUMN_COLAZIONE + " TEXT, " + COLUMN_ALIMENTO + "TEXT, "
            + COLUMN_DATA_INIZIO + "DATE, " + COLUMN_DATA_FINE + " DATE )";


    public DBPasto(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_TABLE_PASTO);
    }


    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS pasto");
        onCreate(database);
    }


    public DBPasto open() throws SQLException {
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

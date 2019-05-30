package com.example.walk4you.Helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.walk4you.util.Constants.*;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "DbWalkForYou";
    private static final int DATABASE_VERSION = 1;

    private static DatabaseHelper databaseHelper;


    private static final String CREATE_TABELLA_UTENTE = "CREATE TABLE " +  TABELLA_UTENTE + "("
            + MAIL + "INTEGER PRIMARY KEY,"
            + NOME + "TEXT"
            + COGNOME + "TEXT"
            + PASSWORD + "TEXT"
            + ALTEZZA +"NUMRO"
            + SESSO + "TEXT"
            + DATA_NASCITA + "DATA" + ")";

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABELLA_UTENTE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABELLA_UTENTE );

        onCreate(db);
    }


}
